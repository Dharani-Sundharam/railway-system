from sqlalchemy import Column, Integer, String, DateTime, Float, Boolean, Text, ForeignKey, Enum
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import relationship
from sqlalchemy.sql import func
import enum

Base = declarative_base()

class ComponentType(enum.Enum):
    ELASTIC_RAIL_CLIP = "ELASTIC_RAIL_CLIP"
    LINER = "LINER"
    RAIL_PAD = "RAIL_PAD"
    SLEEPER = "SLEEPER"

class InspectionStatus(enum.Enum):
    PASSED = "PASSED"
    FAILED = "FAILED"
    PENDING = "PENDING"
    MAINTENANCE_REQUIRED = "MAINTENANCE_REQUIRED"

class ComponentStatus(enum.Enum):
    MANUFACTURED = "MANUFACTURED"
    SHIPPED = "SHIPPED"
    RECEIVED = "RECEIVED"
    INSTALLED = "INSTALLED"
    IN_SERVICE = "IN_SERVICE"
    MAINTENANCE = "MAINTENANCE"
    FAILED = "FAILED"
    WITHDRAWN = "WITHDRAWN"

class User(Base):
    __tablename__ = "users"
    
    id = Column(Integer, primary_key=True, index=True)
    username = Column(String(50), unique=True, index=True, nullable=False)
    email = Column(String(100), unique=True, index=True, nullable=False)
    hashed_password = Column(String(255), nullable=False)
    full_name = Column(String(100))
    role = Column(String(50), default="inspector")
    is_active = Column(Boolean, default=True)
    created_at = Column(DateTime(timezone=True), server_default=func.now())

class Vendor(Base):
    __tablename__ = "vendors"
    
    id = Column(Integer, primary_key=True, index=True)
    vendor_code = Column(String(20), unique=True, index=True, nullable=False)
    name = Column(String(200), nullable=False)
    address = Column(Text)
    contact_person = Column(String(100))
    phone = Column(String(20))
    email = Column(String(100))
    certification_status = Column(String(50), default="active")
    quality_rating = Column(Float, default=0.0)
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    
    # Relationships
    components = relationship("Component", back_populates="vendor")

class Location(Base):
    __tablename__ = "locations"
    
    id = Column(Integer, primary_key=True, index=True)
    zone = Column(String(50), nullable=False)  # e.g., "Western Railway"
    division = Column(String(50), nullable=False)  # e.g., "Mumbai Division"
    section = Column(String(50))  # e.g., "Mumbai-Pune Section"
    station_code = Column(String(10))  # e.g., "CSTM"
    chainage = Column(String(20))  # e.g., "1234/5-6"
    track_number = Column(String(10))
    gps_latitude = Column(Float)
    gps_longitude = Column(Float)
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    
    # Relationships
    components = relationship("Component", back_populates="location")

class Component(Base):
    __tablename__ = "components"
    
    id = Column(Integer, primary_key=True, index=True)
    serial_id = Column(String(50), unique=True, index=True, nullable=False)
    component_type = Column(Enum(ComponentType), nullable=False)
    material_specification = Column(String(100))
    batch_number = Column(String(50))
    lot_number = Column(String(50))
    po_number = Column(String(50))
    manufacturing_date = Column(DateTime)
    dispatch_date = Column(DateTime)
    receiving_date = Column(DateTime)
    installation_date = Column(DateTime)
    warranty_start_date = Column(DateTime)
    warranty_end_date = Column(DateTime)
    current_status = Column(Enum(ComponentStatus), default=ComponentStatus.MANUFACTURED)
    qr_code_path = Column(String(255))
    
    # Foreign keys
    vendor_id = Column(Integer, ForeignKey("vendors.id"))
    location_id = Column(Integer, ForeignKey("locations.id"))
    
    # Metadata
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    updated_at = Column(DateTime(timezone=True), onupdate=func.now())
    
    # Relationships
    vendor = relationship("Vendor", back_populates="components")
    location = relationship("Location", back_populates="components")
    inspections = relationship("Inspection", back_populates="component")
    scan_records = relationship("ScanRecord", back_populates="component")

class Inspection(Base):
    __tablename__ = "inspections"
    
    id = Column(Integer, primary_key=True, index=True)
    component_id = Column(Integer, ForeignKey("components.id"), nullable=False)
    inspector_id = Column(Integer, ForeignKey("users.id"))
    inspection_type = Column(String(50))  # e.g., "manufacturing", "receiving", "periodic", "failure"
    inspection_date = Column(DateTime, nullable=False)
    status = Column(Enum(InspectionStatus), nullable=False)
    findings = Column(Text)
    recommendations = Column(Text)
    next_inspection_due = Column(DateTime)
    defect_category = Column(String(100))
    severity_level = Column(String(20))  # e.g., "low", "medium", "high", "critical"
    
    # Measurements/readings
    measurements = Column(Text)  # JSON string for flexible measurements
    photos = Column(Text)  # JSON array of photo paths
    
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    
    # Relationships
    component = relationship("Component", back_populates="inspections")
    inspector = relationship("User")

class ScanRecord(Base):
    __tablename__ = "scan_records"
    
    id = Column(Integer, primary_key=True, index=True)
    component_id = Column(Integer, ForeignKey("components.id"), nullable=False)
    scanned_by = Column(Integer, ForeignKey("users.id"))
    scan_location = Column(String(200))
    scan_purpose = Column(String(100))  # e.g., "receiving", "inspection", "maintenance"
    timestamp = Column(DateTime(timezone=True), server_default=func.now())
    gps_latitude = Column(Float)
    gps_longitude = Column(Float)
    device_info = Column(Text)  # JSON with device details
    
    # Relationships
    component = relationship("Component", back_populates="scan_records")
    scanned_by_user = relationship("User")

class PurchaseOrder(Base):
    __tablename__ = "purchase_orders"
    
    id = Column(Integer, primary_key=True, index=True)
    po_number = Column(String(50), unique=True, nullable=False)
    vendor_id = Column(Integer, ForeignKey("vendors.id"), nullable=False)
    po_date = Column(DateTime, nullable=False)
    delivery_date = Column(DateTime)
    total_quantity = Column(Integer, nullable=False)
    unit_price = Column(Float)
    total_value = Column(Float)
    status = Column(String(50), default="active")
    terms_conditions = Column(Text)
    
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    
    # Relationships
    vendor = relationship("Vendor")

class QualityMetric(Base):
    __tablename__ = "quality_metrics"
    
    id = Column(Integer, primary_key=True, index=True)
    vendor_id = Column(Integer, ForeignKey("vendors.id"))
    component_type = Column(Enum(ComponentType))
    metric_name = Column(String(100), nullable=False)
    metric_value = Column(Float, nullable=False)
    measurement_date = Column(DateTime, nullable=False)
    benchmark_value = Column(Float)
    status = Column(String(50))  # e.g., "within_spec", "deviation", "critical"
    
    created_at = Column(DateTime(timezone=True), server_default=func.now())
    
    # Relationships
    vendor = relationship("Vendor")
