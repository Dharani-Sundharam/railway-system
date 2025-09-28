#!/usr/bin/env python3
"""
Railway Track Fittings Management System - Unified Application
Serves both backend API and frontend static files
"""

import os
import sys
from pathlib import Path

# Add the backend app to Python path
backend_path = Path(__file__).parent / "backend"
sys.path.insert(0, str(backend_path))

from fastapi import FastAPI, Request
from fastapi.middleware.cors import CORSMiddleware
from fastapi.staticfiles import StaticFiles
from fastapi.responses import FileResponse
from fastapi.responses import HTMLResponse
import uvicorn

# Import the backend app
from app.main import app as backend_app
from app.database import SessionLocal, engine
from app import models, crud, sample_data

# Create the main FastAPI app
app = FastAPI(
    title="Indian Railways Track Fittings Management System",
    description="Unified system for laser-based QR code marking on track fittings",
    version="1.0.0"
)

# CORS middleware
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Configure appropriately for production
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Create database tables
models.Base.metadata.create_all(bind=engine)

# Populate sample data on startup
@app.on_event("startup")
async def startup_event():
    """Populate database with sample data on startup"""
    db = SessionLocal()
    try:
        # Check if data already exists
        existing_components = crud.get_components(db, skip=0, limit=1)
        if not existing_components:
            sample_data.populate_sample_data(db)
            print("Sample data populated successfully!")
    finally:
        db.close()

# Mount the backend API
app.mount("/api", backend_app)

# Serve static files (QR codes, uploads)
static_path = Path(__file__).parent / "backend" / "static"
if static_path.exists():
    app.mount("/static", StaticFiles(directory=str(static_path)), name="static")

# Serve frontend static files
frontend_build_path = Path(__file__).parent / "frontend" / "build"
if frontend_build_path.exists():
    app.mount("/assets", StaticFiles(directory=str(frontend_build_path / "static")), name="assets")

# Serve the React app for all non-API routes
@app.get("/{full_path:path}")
async def serve_frontend(request: Request, full_path: str):
    """Serve the React frontend for all non-API routes"""
    
    # Don't serve frontend for API routes
    if full_path.startswith("api/") or full_path.startswith("static/") or full_path.startswith("assets/"):
        return {"error": "Not found"}
    
    # Serve index.html for all other routes (React Router)
    index_path = frontend_build_path / "index.html"
    if index_path.exists():
        return FileResponse(str(index_path))
    else:
        return HTMLResponse("""
        <html>
            <head><title>Railway System</title></head>
            <body>
                <h1>Railway Track Fittings Management System</h1>
                <p>Frontend not built yet. Please run:</p>
                <code>cd website/frontend && npm install && npm run build</code>
                <p>Then restart the application.</p>
                <p><a href="/api/docs">API Documentation</a></p>
            </body>
        </html>
        """)

# Health check
@app.get("/")
async def root():
    """Root endpoint - redirect to frontend"""
    return {"message": "Indian Railways Track Fittings Management System", "status": "running", "api_docs": "/api/docs"}

if __name__ == "__main__":
    port = int(os.getenv("PORT", 8000))
    uvicorn.run(app, host="0.0.0.0", port=port)
