#!/usr/bin/env python3
"""
Fix passwords in the database to use simple plain text verification
This script updates existing user passwords to plain text for simple verification
"""

import os
import sys
from pathlib import Path

# Add the backend app to Python path
backend_path = Path(__file__).parent / "backend"
sys.path.insert(0, str(backend_path))

from app.database import SessionLocal
from app import models

def fix_passwords_to_plain_text():
    """Fix passwords to plain text for simple verification"""
    print("🔧 Fixing passwords to plain text for simple verification...")
    
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
            
            # Update the user's password to plain text
            user.hashed_password = password
            updated_count += 1
            
            print(f"✅ Updated password for user: {user.username} -> {password}")
        
        # Commit the changes
        db.commit()
        print(f"🎉 Successfully updated {updated_count} user passwords to plain text!")
        
    except Exception as e:
        print(f"❌ Error fixing passwords: {e}")
        db.rollback()
        raise
    finally:
        db.close()

if __name__ == "__main__":
    fix_passwords_to_plain_text()
