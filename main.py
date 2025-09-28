#!/usr/bin/env python3
"""
Railway Track Fittings Management System - Unified Application
Serves both backend API and frontend static files
"""

import os
import sys
from pathlib import Path
from contextlib import asynccontextmanager

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

@asynccontextmanager
async def lifespan(app: FastAPI):
    """Application lifespan handler"""
    # Startup
    print("🚂 Starting up Railway System...")
    
    # Create database tables
    print("📋 Creating database tables...")
    models.Base.metadata.create_all(bind=engine)
    print("✅ Database tables created!")
    
    # Populate sample data on startup
    db = SessionLocal()
    try:
        # Check if data already exists
        existing_users = db.query(models.User).first()
        if not existing_users:
            print("📊 Populating sample data...")
            sample_data.populate_sample_data(db)
            print("✅ Sample data populated successfully!")
        else:
            print("ℹ️  Database already contains data, skipping sample data population")
            
        # Verify admin user exists
        admin_user = crud.get_user_by_username(db, "admin")
        if admin_user:
            print(f"✅ Admin user found: {admin_user.username}")
            
            # Test password verification
            try:
                test_auth = crud.authenticate_user(db, "admin", "admin123")
                if test_auth:
                    print("✅ Admin password verification working")
                else:
                    print("⚠️  Admin password verification failed - fixing passwords...")
                    # Import and run password fix
                    from fix_passwords import fix_user_passwords
                    fix_user_passwords()
            except Exception as e:
                print(f"⚠️  Password verification error: {e} - fixing passwords...")
                # Import and run password fix
                from fix_passwords import fix_user_passwords
                fix_user_passwords()
        else:
            print("❌ Admin user not found!")
            
    except Exception as e:
        print(f"❌ Error during startup: {e}")
        raise
    finally:
        db.close()
    
    print("🎉 Railway System startup complete!")
    
    yield
    
    # Shutdown
    print("🛑 Shutting down Railway System...")

# Create the main FastAPI app
app = FastAPI(
    title="Indian Railways Track Fittings Management System",
    description="Unified system for laser-based QR code marking on track fittings",
    version="1.0.0",
    lifespan=lifespan
)

# CORS middleware
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Configure appropriately for production
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Database tables and sample data are now handled in the lifespan function

# Mount the backend API
app.mount("/api", backend_app)

# Serve backend static files (QR codes, uploads) at a different path
backend_static_path = Path(__file__).parent / "backend" / "static"
if backend_static_path.exists():
    app.mount("/backend-static", StaticFiles(directory=str(backend_static_path)), name="backend-static")

# Serve frontend static files (CSS, JS, etc.)
frontend_build_path = Path(__file__).parent / "frontend" / "build"
if frontend_build_path.exists():
    # Mount static files from the build directory
    app.mount("/static", StaticFiles(directory=str(frontend_build_path / "static")), name="static")
    
    # Serve other static files from build root
    @app.get("/favicon.ico")
    async def favicon():
        favicon_path = frontend_build_path / "favicon.ico"
        if favicon_path.exists():
            return FileResponse(str(favicon_path))
        return {"error": "Not found"}
    
    @app.get("/manifest.json")
    async def manifest():
        manifest_path = frontend_build_path / "manifest.json"
        if manifest_path.exists():
            return FileResponse(str(manifest_path))
        return {"error": "Not found"}
    
    @app.get("/main_logo_32.png")
    async def logo_32():
        logo_path = frontend_build_path / "main_logo_32.png"
        if logo_path.exists():
            return FileResponse(str(logo_path))
        return {"error": "Not found"}
    
    @app.get("/main_logo_64.png")
    async def logo_64():
        logo_path = frontend_build_path / "main_logo_64.png"
        if logo_path.exists():
            return FileResponse(str(logo_path))
        return {"error": "Not found"}

# Serve the React app for all non-API routes
@app.get("/{full_path:path}")
async def serve_frontend(request: Request, full_path: str):
    """Serve the React frontend for all non-API routes"""
    
    # Don't serve frontend for API routes or static files
    if (full_path.startswith("api/") or 
        full_path.startswith("static/") or 
        full_path.startswith("backend-static/") or
        full_path in ["favicon.ico", "manifest.json", "robots.txt", "main_logo_32.png", "main_logo_64.png"]):
        return {"error": "Not found"}
    
    # Serve index.html for all other routes (React Router)
    if frontend_build_path.exists():
        index_path = frontend_build_path / "index.html"
        if index_path.exists():
            return FileResponse(str(index_path))
    
    # Fallback if frontend not built
    return HTMLResponse("""
    <html>
        <head><title>Railway System</title></head>
        <body>
            <h1>Railway Track Fittings Management System</h1>
            <p>Frontend not built yet. Please run:</p>
            <code>cd frontend && npm install && npm run build</code>
            <p>Then restart the application.</p>
            <p><a href="/api/docs">API Documentation</a></p>
        </body>
    </html>
    """)

# Test login page
@app.get("/test-login")
async def test_login_page():
    """Test login page for debugging"""
    test_path = Path(__file__).parent / "test-login.html"
    if test_path.exists():
        return FileResponse(str(test_path))
    return {"error": "Test page not found"}

# Health check
@app.get("/")
async def root():
    """Root endpoint - redirect to frontend"""
    return {"message": "Indian Railways Track Fittings Management System", "status": "running", "api_docs": "/api/docs"}

if __name__ == "__main__":
    port = int(os.getenv("PORT", 8000))
    uvicorn.run(app, host="0.0.0.0", port=port)
