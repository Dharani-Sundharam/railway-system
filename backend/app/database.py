from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker
import os
from dotenv import load_dotenv

load_dotenv()

# Database configuration - Force SQLite for this deployment
DATABASE_URL = os.getenv("DATABASE_URL", "sqlite:///./backend/railway_fittings.db")

# Ensure we're using SQLite (override any PostgreSQL URLs)
if not DATABASE_URL.startswith("sqlite"):
    print(f"Warning: Overriding DATABASE_URL from {DATABASE_URL} to SQLite")
    DATABASE_URL = "sqlite:///./backend/railway_fittings.db"

# Create engine
engine = create_engine(
    DATABASE_URL, 
    connect_args={"check_same_thread": False}  # Only for SQLite
)

# Create session factory
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# Create declarative base
Base = declarative_base()

def get_database():
    """Get database session"""
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
