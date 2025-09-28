#!/usr/bin/env python3
"""
Fix password hashes in the database
This script updates existing user passwords to use proper bcrypt hashing
"""

import os
import sys
from pathlib import Path

# Add the backend app to Python path
backend_path = Path(__file__).parent / "backend"
sys.path.insert(0, str(backend_path))

from app.database import SessionLocal
from app import models, crud

def fix_user_passwords():
    """Fix password hashes for all users"""
    print("🔧 Fixing user password hashes...")
    
    db = SessionLocal()
    try:
        # Get all users
        users = db.query(models.User).all()
        
        if not users:
            print("ℹ️  No users found in database")
            return
            
        print(f"📋 Found {len(users)} users to update")
        
        # Default passwords for demo users
        default_passwords = {
            "admin": "admin123",
            "inspector1": "inspector123", 
            "depot_manager": "depot123",
            "vendor_rep": "vendor123"
        }
        
        updated_count = 0
        for user in users:
            # Get the default password for this user
            password = default_passwords.get(user.username, "password123")
            
            # Hash the password properly
            hashed_password = crud.get_password_hash(password)
            
            # Update the user's password
            user.hashed_password = hashed_password
            updated_count += 1
            
            print(f"✅ Updated password for user: {user.username}")
        
        # Commit the changes
        db.commit()
        print(f"🎉 Successfully updated {updated_count} user passwords!")
        
    except Exception as e:
        print(f"❌ Error fixing passwords: {e}")
        db.rollback()
        raise
    finally:
        db.close()

if __name__ == "__main__":
    fix_user_passwords()
