from sqlalchemy.orm import Session
from sqlalchemy import func, and_, or_
from datetime import datetime, timedelta
from typing import Optional, List
from passlib.context import CryptContext
from jose import JWTError, jwt
from . import models, schemas
import os
from datetime import datetime, timedelta

# Security
SECRET_KEY = os.getenv("SECRET_KEY", "your-secret-key-change-this-in-production")
ALGORITHM = "HS256"
ACCESS_TOKEN_EXPIRE_MINUTES = 30

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

def verify_password(plain_password, hashed_password):
    return pwd_context.verify(plain_password, hashed_password)

def get_password_hash(password):
    return pwd_context.hash(password)

def create_access_token(data: dict, expires_delta: Optional[timedelta] = None):
    to_encode = data.copy()
    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.utcnow() + timedelta(minutes=15)
    to_encode.update({"exp": expire})
    encoded_jwt = jwt.encode(to_encode, SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt

# User operations
def get_user_by_username(db: Session, username: str):
    return db.query(models.User).filter(models.User.username == username).first()

def authenticate_user(db: Session, username: str, password: str):
    user = get_user_by_username(db, username)
    if not user:
        return False
    if not verify_password(password, user.hashed_password):
        return False
    return user

def create_user(db: Session, user: schemas.UserCreate):
    hashed_password = get_password_hash(user.password)
    db_user = models.User(
        username=user.username,
        email=user.email,
        full_name=user.full_name,
        role=user.role,
        hashed_password=hashed_password
    )
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user

# Vendor operations
def get_vendors(db: Session, skip: int = 0, limit: int = 100):
    return db.query(models.Vendor).offset(skip).limit(limit).all()

def get_vendor_by_code(db: Session, vendor_code: str):
    return db.query(models.Vendor).filter(models.Vendor.vendor_code == vendor_code).first()

def create_vendor(db: Session, vendor: schemas.VendorCreate):
    db_vendor = models.Vendor(**vendor.dict())
    db.add(db_vendor)
    db.commit()
    db.refresh(db_vendor)
    return db_vendor

# Location operations
def create_location(db: Session, location: schemas.LocationCreate):
    db_location = models.Location(**location.dict())
    db.add(db_location)
    db.commit()
    db.refresh(db_location)
    return db_location

def get_locations(db: Session, skip: int = 0, limit: int = 100):
    return db.query(models.Location).offset(skip).limit(limit).all()

# Component operations
def get_components(db: Session, skip: int = 0, limit: int = 100):
    return db.query(models.Component).offset(skip).limit(limit).all()

def get_component_by_serial(db: Session, serial_id: str):
    return db.query(models.Component).filter(models.Component.serial_id == serial_id).first()

def create_component(db: Session, component: schemas.ComponentCreate):
    db_component = models.Component(**component.dict())
    db.add(db_component)
    db.commit()
    db.refresh(db_component)
    return db_component

def update_component_status(db: Session, component_id: int, status: models.ComponentStatus):
    db_component = db.query(models.Component).filter(models.Component.id == component_id).first()
    if db_component:
        db_component.current_status = status
        db_component.updated_at = datetime.utcnow()
        db.commit()
        db.refresh(db_component)
    return db_component

# Inspection operations
def get_inspections(db: Session, skip: int = 0, limit: int = 100):
    return db.query(models.Inspection).offset(skip).limit(limit).all()

def create_inspection(db: Session, inspection: schemas.InspectionCreate):
    db_inspection = models.Inspection(**inspection.dict())
    db.add(db_inspection)
    db.commit()
    db.refresh(db_inspection)
    return db_inspection

def get_inspections_by_component(db: Session, component_id: int):
    return db.query(models.Inspection).filter(models.Inspection.component_id == component_id).all()

# Scan record operations
def create_scan_record(db: Session, component_id: str, scan_data: schemas.ScanData):
    component = get_component_by_serial(db, component_id)
    if not component:
        return None
    
    db_scan = models.ScanRecord(
        component_id=component.id,
        **scan_data.dict()
    )
    db.add(db_scan)
    db.commit()
    db.refresh(db_scan)
    return db_scan

def get_scan_records_by_component(db: Session, component_id: int):
    return db.query(models.ScanRecord).filter(models.ScanRecord.component_id == component_id).all()

# Analytics operations
def get_dashboard_analytics(db: Session):
    """Get dashboard analytics data"""
    total_components = db.query(models.Component).count()
    
    # Components by type
    components_by_type = {}
    for component_type in models.ComponentType:
        count = db.query(models.Component).filter(
            models.Component.component_type == component_type
        ).count()
        components_by_type[component_type.value] = count
    
    # Components by status
    components_by_status = {}
    for status in models.ComponentStatus:
        count = db.query(models.Component).filter(
            models.Component.current_status == status
        ).count()
        components_by_status[status.value] = count
    
    # Recent inspections (last 30 days)
    thirty_days_ago = datetime.utcnow() - timedelta(days=30)
    recent_inspections = db.query(models.Inspection).filter(
        models.Inspection.inspection_date >= thirty_days_ago
    ).count()
    
    # Failed components
    failed_components = db.query(models.Component).filter(
        models.Component.current_status == models.ComponentStatus.FAILED
    ).count()
    
    # Vendor count
    vendor_count = db.query(models.Vendor).count()
    
    # Average quality rating
    avg_quality = db.query(func.avg(models.Vendor.quality_rating)).scalar() or 0.0
    
    return {
        "total_components": total_components,
        "components_by_type": components_by_type,
        "components_by_status": components_by_status,
        "recent_inspections": recent_inspections,
        "failed_components": failed_components,
        "vendor_count": vendor_count,
        "average_quality_rating": round(avg_quality, 2)
    }

def get_vendor_performance_metrics(db: Session):
    """Get vendor performance metrics"""
    vendors = db.query(models.Vendor).all()
    performance_data = []
    
    for vendor in vendors:
        total_components = db.query(models.Component).filter(
            models.Component.vendor_id == vendor.id
        ).count()
        
        failed_components = db.query(models.Component).filter(
            and_(
                models.Component.vendor_id == vendor.id,
                models.Component.current_status == models.ComponentStatus.FAILED
            )
        ).count()
        
        failure_rate = (failed_components / total_components * 100) if total_components > 0 else 0
        
        # Mock on-time delivery for demo
        on_time_delivery = 95.0 - (failure_rate * 2)  # Inverse correlation for demo
        
        performance_data.append({
            "vendor_id": vendor.id,
            "vendor_name": vendor.name,
            "vendor_code": vendor.vendor_code,
            "total_components": total_components,
            "failed_components": failed_components,
            "failure_rate": round(failure_rate, 2),
            "quality_rating": vendor.quality_rating,
            "on_time_delivery": round(max(0, on_time_delivery), 2)
        })
    
    return performance_data

def get_component_lifecycle_data(db: Session, component_id: str):
    """Get complete lifecycle data for a component"""
    component = get_component_by_serial(db, component_id)
    if not component:
        return None
    
    inspections = get_inspections_by_component(db, component.id)
    scan_records = get_scan_records_by_component(db, component.id)
    
    # Create timeline events
    timeline_events = []
    
    if component.manufacturing_date:
        timeline_events.append({
            "date": component.manufacturing_date,
            "event": "Manufacturing",
            "description": f"Component {component.serial_id} manufactured"
        })
    
    if component.dispatch_date:
        timeline_events.append({
            "date": component.dispatch_date,
            "event": "Dispatch",
            "description": "Component dispatched from vendor"
        })
    
    if component.receiving_date:
        timeline_events.append({
            "date": component.receiving_date,
            "event": "Received",
            "description": "Component received at depot"
        })
    
    if component.installation_date:
        timeline_events.append({
            "date": component.installation_date,
            "event": "Installation",
            "description": "Component installed on track"
        })
    
    for inspection in inspections:
        timeline_events.append({
            "date": inspection.inspection_date,
            "event": "Inspection",
            "description": f"{inspection.inspection_type} - {inspection.status.value}",
            "details": inspection.findings
        })
    
    for scan in scan_records:
        timeline_events.append({
            "date": scan.timestamp,
            "event": "Scan",
            "description": f"Scanned for {scan.scan_purpose}",
            "location": scan.scan_location
        })
    
    # Sort timeline by date
    timeline_events.sort(key=lambda x: x["date"])
    
    return {
        "component": component,
        "inspections": inspections,
        "scan_records": scan_records,
        "timeline_events": timeline_events
    }

# Purchase Order operations
def create_purchase_order(db: Session, po: schemas.PurchaseOrderCreate):
    db_po = models.PurchaseOrder(**po.dict())
    db.add(db_po)
    db.commit()
    db.refresh(db_po)
    return db_po

def get_purchase_orders(db: Session, skip: int = 0, limit: int = 100):
    return db.query(models.PurchaseOrder).offset(skip).limit(limit).all()

# Quality Metric operations
def create_quality_metric(db: Session, metric: schemas.QualityMetricCreate):
    db_metric = models.QualityMetric(**metric.dict())
    db.add(db_metric)
    db.commit()
    db.refresh(db_metric)
    return db_metric

def get_quality_metrics(db: Session, vendor_id: Optional[int] = None, skip: int = 0, limit: int = 100):
    query = db.query(models.QualityMetric)
    if vendor_id:
        query = query.filter(models.QualityMetric.vendor_id == vendor_id)
    return query.offset(skip).limit(limit).all()
