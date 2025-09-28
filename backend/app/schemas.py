from pydantic import BaseModel, EmailStr
from datetime import datetime
from typing import Optional, List
from enum import Enum

# Enums
class ComponentTypeEnum(str, Enum):
    ELASTIC_RAIL_CLIP = "ELASTIC_RAIL_CLIP"
    LINER = "LINER"
    RAIL_PAD = "RAIL_PAD"
    SLEEPER = "SLEEPER"

class InspectionStatusEnum(str, Enum):
    PASSED = "PASSED"
    FAILED = "FAILED"
    PENDING = "PENDING"
    MAINTENANCE_REQUIRED = "MAINTENANCE_REQUIRED"

class ComponentStatusEnum(str, Enum):
    MANUFACTURED = "MANUFACTURED"
    SHIPPED = "SHIPPED"
    RECEIVED = "RECEIVED"
    INSTALLED = "INSTALLED"
    IN_SERVICE = "IN_SERVICE"
    MAINTENANCE = "MAINTENANCE"
    FAILED = "FAILED"
    WITHDRAWN = "WITHDRAWN"

# Base schemas
class UserBase(BaseModel):
    username: str
    email: EmailStr
    full_name: Optional[str] = None
    role: str = "inspector"

class UserCreate(UserBase):
    password: str

class UserLogin(BaseModel):
    username: str
    password: str

class User(UserBase):
    id: int
    is_active: bool
    created_at: datetime
    
    class Config:
        from_attributes = True

class Token(BaseModel):
    access_token: str
    token_type: str

class VendorBase(BaseModel):
    vendor_code: str
    name: str
    address: Optional[str] = None
    contact_person: Optional[str] = None
    phone: Optional[str] = None
    email: Optional[str] = None
    certification_status: str = "active"
    quality_rating: float = 0.0

class VendorCreate(VendorBase):
    pass

class Vendor(VendorBase):
    id: int
    created_at: datetime
    
    class Config:
        from_attributes = True

class LocationBase(BaseModel):
    zone: str
    division: str
    section: Optional[str] = None
    station_code: Optional[str] = None
    chainage: Optional[str] = None
    track_number: Optional[str] = None
    gps_latitude: Optional[float] = None
    gps_longitude: Optional[float] = None

class LocationCreate(LocationBase):
    pass

class Location(LocationBase):
    id: int
    created_at: datetime
    
    class Config:
        from_attributes = True

class ComponentBase(BaseModel):
    serial_id: str
    component_type: ComponentTypeEnum
    material_specification: Optional[str] = None
    batch_number: Optional[str] = None
    lot_number: Optional[str] = None
    po_number: Optional[str] = None
    manufacturing_date: Optional[datetime] = None
    dispatch_date: Optional[datetime] = None
    receiving_date: Optional[datetime] = None
    installation_date: Optional[datetime] = None
    warranty_start_date: Optional[datetime] = None
    warranty_end_date: Optional[datetime] = None
    current_status: ComponentStatusEnum = ComponentStatusEnum.MANUFACTURED

class ComponentCreate(ComponentBase):
    vendor_id: int
    location_id: Optional[int] = None

class Component(ComponentBase):
    id: int
    vendor_id: int
    location_id: Optional[int] = None
    qr_code_path: Optional[str] = None
    created_at: datetime
    updated_at: Optional[datetime] = None
    
    # Relationships
    vendor: Optional[Vendor] = None
    location: Optional[Location] = None
    
    class Config:
        from_attributes = True

class InspectionBase(BaseModel):
    inspection_type: str
    inspection_date: datetime
    status: InspectionStatusEnum
    findings: Optional[str] = None
    recommendations: Optional[str] = None
    next_inspection_due: Optional[datetime] = None
    defect_category: Optional[str] = None
    severity_level: Optional[str] = None
    measurements: Optional[str] = None
    photos: Optional[str] = None

class InspectionCreate(InspectionBase):
    component_id: int
    inspector_id: Optional[int] = None

class Inspection(InspectionBase):
    id: int
    component_id: int
    inspector_id: Optional[int] = None
    created_at: datetime
    
    class Config:
        from_attributes = True

class ScanDataBase(BaseModel):
    scan_location: Optional[str] = None
    scan_purpose: str = "inspection"
    gps_latitude: Optional[float] = None
    gps_longitude: Optional[float] = None
    device_info: Optional[str] = None

class ScanData(ScanDataBase):
    pass

class ScanRecord(ScanDataBase):
    id: int
    component_id: int
    scanned_by: Optional[int] = None
    timestamp: datetime
    
    class Config:
        from_attributes = True

class PurchaseOrderBase(BaseModel):
    po_number: str
    po_date: datetime
    delivery_date: Optional[datetime] = None
    total_quantity: int
    unit_price: Optional[float] = None
    total_value: Optional[float] = None
    status: str = "active"
    terms_conditions: Optional[str] = None

class PurchaseOrderCreate(PurchaseOrderBase):
    vendor_id: int

class PurchaseOrder(PurchaseOrderBase):
    id: int
    vendor_id: int
    created_at: datetime
    
    class Config:
        from_attributes = True

class QualityMetricBase(BaseModel):
    metric_name: str
    metric_value: float
    measurement_date: datetime
    benchmark_value: Optional[float] = None
    status: Optional[str] = None

class QualityMetricCreate(QualityMetricBase):
    vendor_id: int
    component_type: ComponentTypeEnum

class QualityMetric(QualityMetricBase):
    id: int
    vendor_id: int
    component_type: ComponentTypeEnum
    created_at: datetime
    
    class Config:
        from_attributes = True

# Analytics schemas
class DashboardData(BaseModel):
    total_components: int
    components_by_type: dict
    components_by_status: dict
    recent_inspections: int
    failed_components: int
    vendor_count: int
    average_quality_rating: float

class VendorPerformance(BaseModel):
    vendor_id: int
    vendor_name: str
    vendor_code: str
    total_components: int
    failed_components: int
    failure_rate: float
    quality_rating: float
    on_time_delivery: float

class ComponentLifecycle(BaseModel):
    component: Component
    inspections: List[Inspection]
    scan_records: List[ScanRecord]
    timeline_events: List[dict]

# Report schemas
class ComponentReport(BaseModel):
    component_id: str
    generated_at: str
    report_content: str
    component_summary: dict
    raw_data: dict

class BulkReport(BaseModel):
    bulk_report: str
    individual_reports: List[ComponentReport]
    generated_at: str
    total_components: int

class ReportRequest(BaseModel):
    component_ids: List[str]
    report_type: str = "individual"  # "individual" or "bulk"