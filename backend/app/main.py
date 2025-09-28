from fastapi import FastAPI, Depends, HTTPException, status, UploadFile, File
from fastapi.middleware.cors import CORSMiddleware
from fastapi.staticfiles import StaticFiles
from fastapi.responses import FileResponse
from sqlalchemy.orm import Session
import os
from . import models, schemas, crud, database
from .database import SessionLocal, engine
from .auth import get_current_user
from .qr_generator import generate_component_qr
from .sample_data import populate_sample_data
from .report_generator import generate_component_report, generate_bulk_report

# Create database tables
models.Base.metadata.create_all(bind=engine)

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

# Static files
os.makedirs("static/qr_codes", exist_ok=True)
app.mount("/static", StaticFiles(directory="static"), name="static")

# Dependency to get database session
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

@app.on_event("startup")
async def startup_event():
    """Populate database with sample data on startup"""
    db = SessionLocal()
    try:
        # Check if data already exists
        existing_components = crud.get_components(db, skip=0, limit=1)
        if not existing_components:
            populate_sample_data(db)
            print("Sample data populated successfully!")
    finally:
        db.close()

# Health check
@app.get("/")
def read_root():
    return {"message": "Indian Railways Track Fittings Management System API", "status": "running"}


# Authentication endpoints
@app.post("/auth/login", response_model=schemas.Token)
def login(user_credentials: schemas.UserLogin, db: Session = Depends(get_db)):
    """Login endpoint"""
    print(f"🔐 Login attempt: username={user_credentials.username}")
    user = crud.authenticate_user(db, user_credentials.username, user_credentials.password)
    if not user:
        print(f"❌ Login failed for username: {user_credentials.username}")
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Incorrect username or password",
            headers={"WWW-Authenticate": "Bearer"},
        )
    print(f"✅ Login successful for user: {user.username}")
    access_token = crud.create_access_token(data={"sub": user.username})
    return {"access_token": access_token, "token_type": "bearer"}

# Component endpoints
@app.get("/components/", response_model=list[schemas.Component])
def read_components(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    """Get all components with pagination"""
    components = crud.get_components(db, skip=skip, limit=limit)
    return components

@app.get("/components/{component_id}", response_model=schemas.Component)
def read_component(component_id: str, db: Session = Depends(get_db)):
    """Get component by serial ID"""
    component = crud.get_component_by_serial(db, component_id)
    if component is None:
        raise HTTPException(status_code=404, detail="Component not found")
    return component

@app.post("/components/", response_model=schemas.Component)
def create_component(component: schemas.ComponentCreate, db: Session = Depends(get_db)):
    """Create new component"""
    return crud.create_component(db=db, component=component)

@app.post("/components/{component_id}/qr")
def generate_qr_code(component_id: str, db: Session = Depends(get_db)):
    """Generate QR code for component"""
    component = crud.get_component_by_serial(db, component_id)
    if component is None:
        raise HTTPException(status_code=404, detail="Component not found")
    
    qr_path = generate_component_qr(component)
    return {"qr_code_url": f"/static/qr_codes/{component.serial_id}.png"}

# Vendor endpoints
@app.get("/vendors/", response_model=list[schemas.Vendor])
def read_vendors(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    """Get all vendors"""
    vendors = crud.get_vendors(db, skip=skip, limit=limit)
    return vendors

@app.post("/vendors/", response_model=schemas.Vendor)
def create_vendor(vendor: schemas.VendorCreate, db: Session = Depends(get_db)):
    """Create new vendor"""
    return crud.create_vendor(db=db, vendor=vendor)

# Inspection endpoints
@app.get("/inspections/", response_model=list[schemas.Inspection])
def read_inspections(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    """Get all inspections"""
    inspections = crud.get_inspections(db, skip=skip, limit=limit)
    return inspections

@app.post("/inspections/", response_model=schemas.Inspection)
def create_inspection(inspection: schemas.InspectionCreate, db: Session = Depends(get_db)):
    """Create new inspection record"""
    return crud.create_inspection(db=db, inspection=inspection)

# Mobile scanning endpoint
@app.post("/scan/{component_id}")
def scan_component(component_id: str, scan_data: schemas.ScanData, db: Session = Depends(get_db)):
    """Handle mobile QR scan"""
    component = crud.get_component_by_serial(db, component_id)
    if component is None:
        raise HTTPException(status_code=404, detail="Component not found")
    
    # Log scan event
    scan_record = crud.create_scan_record(db, component_id, scan_data)
    
    return {
        "component": component,
        "scan_recorded": True,
        "timestamp": scan_record.timestamp
    }

# Analytics endpoints
@app.get("/analytics/dashboard")
def get_dashboard_data(db: Session = Depends(get_db)):
    """Get dashboard analytics data"""
    return crud.get_dashboard_analytics(db)

@app.get("/analytics/vendor-performance")
def get_vendor_performance(db: Session = Depends(get_db)):
    """Get vendor performance metrics"""
    return crud.get_vendor_performance_metrics(db)

@app.get("/analytics/component-lifecycle/{component_id}")
def get_component_lifecycle(component_id: str, db: Session = Depends(get_db)):
    """Get complete lifecycle data for a component"""
    return crud.get_component_lifecycle_data(db, component_id)

# Bulk operations
@app.post("/components/bulk-create")
def bulk_create_components(components: list[schemas.ComponentCreate], db: Session = Depends(get_db)):
    """Bulk create components"""
    created_components = []
    for component_data in components:
        component = crud.create_component(db, component_data)
        created_components.append(component)
    return {"created_count": len(created_components), "components": created_components}

# Report generation endpoints
@app.post("/reports/component/{component_id}")
def generate_component_report_endpoint(component_id: str, db: Session = Depends(get_db)):
    """Generate AI-powered report for a single component"""
    try:
        report = generate_component_report(db, component_id)
        return report
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Failed to generate report: {str(e)}")

@app.post("/reports/bulk")
def generate_bulk_report_endpoint(request: schemas.ReportRequest, db: Session = Depends(get_db)):
    """Generate AI-powered bulk report for multiple components"""
    try:
        if request.report_type == "bulk":
            report = generate_bulk_report(db, request.component_ids)
        else:
            # Generate individual reports
            reports = []
            for component_id in request.component_ids:
                report = generate_component_report(db, component_id)
                reports.append(report)
            report = {
                "individual_reports": reports,
                "generated_at": reports[0]["generated_at"] if reports else None,
                "total_components": len(request.component_ids)
            }
        return report
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Failed to generate bulk report: {str(e)}")

@app.get("/reports/component/{component_id}/preview")
def get_component_report_preview(component_id: str, db: Session = Depends(get_db)):
    """Get a quick preview of component data for report generation"""
    try:
        component = crud.get_component_by_serial(db, component_id)
        if not component:
            raise HTTPException(status_code=404, detail="Component not found")
        
        inspections = crud.get_inspections_by_component(db, component.id)
        scan_records = crud.get_scan_records_by_component(db, component.id)
        
        return {
            "component_id": component_id,
            "component_type": component.component_type.value,
            "current_status": component.current_status.value,
            "vendor": component.vendor.name if component.vendor else None,
            "location": f"{component.location.zone} - {component.location.division}" if component.location else None,
            "total_inspections": len(inspections),
            "total_scans": len(scan_records),
            "last_inspection": max([i.inspection_date for i in inspections]).isoformat() if inspections else None,
            "manufacturing_date": component.manufacturing_date.isoformat() if component.manufacturing_date else None,
            "warranty_end_date": component.warranty_end_date.isoformat() if component.warranty_end_date else None,
        }
    except Exception as e:
        raise HTTPException(status_code=500, detail=f"Failed to get component preview: {str(e)}")

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)
