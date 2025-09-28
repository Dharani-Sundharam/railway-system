#!/usr/bin/env python3
"""
Test script to verify database configuration
"""

import os
import sys
from pathlib import Path

# Add the backend app to Python path
backend_path = Path(__file__).parent / "backend"
sys.path.insert(0, str(backend_path))

# Set environment variable to ensure SQLite
os.environ["DATABASE_URL"] = "sqlite:///./railway_fittings.db"

try:
    from app.database import engine, SessionLocal
    from app import models
    
    print("✅ Database configuration loaded successfully")
    print(f"✅ Engine created: {engine}")
    
    # Test database connection
    with engine.connect() as conn:
        from sqlalchemy import text
        result = conn.execute(text("SELECT 1"))
        print("✅ Database connection test successful")
    
    # Test creating tables
    models.Base.metadata.create_all(bind=engine)
    print("✅ Database tables created successfully")
    
    # Test session
    db = SessionLocal()
    try:
        # Simple query to test session
        from sqlalchemy import text
        result = db.execute(text("SELECT 1"))
        print("✅ Database session test successful")
    finally:
        db.close()
    
    print("\n🎉 All database tests passed! Ready for deployment.")
    
except Exception as e:
    print(f"❌ Database test failed: {e}")
    sys.exit(1)
