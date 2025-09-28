#!/usr/bin/env python3
"""
Deployment script for Railway System
Ensures database is properly initialized before starting the application
"""

import os
import sys
from pathlib import Path

# Add the backend app to Python path
backend_path = Path(__file__).parent / "backend"
sys.path.insert(0, str(backend_path))

from app.database import SessionLocal, engine
from app import models, crud, sample_data

def initialize_database():
    """Initialize database and populate sample data"""
    print("🚂 Initializing Railway System Database...")
    
    # Create database tables
    print("📋 Creating database tables...")
    models.Base.metadata.create_all(bind=engine)
    print("✅ Database tables created!")
    
    # Check if data already exists
    db = SessionLocal()
    try:
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
        else:
            print("❌ Admin user not found!")
            
    except Exception as e:
        print(f"❌ Error during database initialization: {e}")
        raise
    finally:
        db.close()
    
    print("🎉 Database initialization complete!")

if __name__ == "__main__":
    initialize_database()
