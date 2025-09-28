from faker import Faker
from datetime import datetime, timedelta
import random
from sqlalchemy.orm import Session
from . import models, crud, schemas
from .qr_generator import generate_component_qr

fake = Faker('en_IN')  # Use Indian locale for more relevant data

def populate_sample_data(db: Session):
    """Populate database with realistic sample data"""
    
    print("Creating sample users...")
    # Create sample users
    sample_users = [
        {"username": "admin", "email": "admin@indianrailways.gov.in", "full_name": "System Administrator", "role": "admin", "password": "admin123"},
        {"username": "inspector1", "email": "inspector1@indianrailways.gov.in", "full_name": "Rajesh Kumar", "role": "inspector", "password": "inspector123"},
        {"username": "depot_manager", "email": "depot@indianrailways.gov.in", "full_name": "Priya Sharma", "role": "depot_manager", "password": "depot123"},
        {"username": "vendor_rep", "email": "vendor@example.com", "full_name": "Amit Patel", "role": "vendor", "password": "vendor123"},
    ]
    
    for user_data in sample_users:
        user = schemas.UserCreate(**user_data)
        crud.create_user(db, user)
    
    print("Creating sample vendors...")
    # Create sample vendors
    sample_vendors = [
        {
            "vendor_code": "RAIL001",
            "name": "Bharat Rail Components Ltd",
            "address": "Plot 123, Industrial Area, Pune, Maharashtra 411019",
            "contact_person": "Suresh Gupta",
            "phone": "+91-20-2345-6789",
            "email": "contact@bharatrail.com",
            "quality_rating": 4.2
        },
        {
            "vendor_code": "STEEL002", 
            "name": "Indian Steel Fittings Pvt Ltd",
            "address": "Sector 15, Industrial Estate, Chennai, Tamil Nadu 600032",
            "contact_person": "Lakshmi Narayanan",
            "phone": "+91-44-2876-5432",
            "email": "info@indiansteel.co.in",
            "quality_rating": 3.8
        },
        {
            "vendor_code": "METRO003",
            "name": "Metro Rail Solutions",
            "address": "Block A, Tech Park, Gurgaon, Haryana 122001",
            "contact_person": "Vikram Singh",
            "phone": "+91-124-4567-890",
            "email": "sales@metrorail.in",
            "quality_rating": 4.5
        },
        {
            "vendor_code": "TRACK004",
            "name": "TrackTech Industries",
            "address": "Industrial Zone 2, Kolkata, West Bengal 700091",
            "contact_person": "Anita Das",
            "phone": "+91-33-2456-7891",
            "email": "orders@tracktech.co.in",
            "quality_rating": 3.9
        },
        {
            "vendor_code": "CLIP005",
            "name": "Precision Rail Clips Ltd",
            "address": "MIDC Area, Aurangabad, Maharashtra 431001",
            "contact_person": "Ravi Joshi",
            "phone": "+91-240-2345-678",
            "email": "precision@railclips.com",
            "quality_rating": 4.1
        }
    ]
    
    vendors = []
    for vendor_data in sample_vendors:
        vendor = schemas.VendorCreate(**vendor_data)
        db_vendor = crud.create_vendor(db, vendor)
        vendors.append(db_vendor)
    
    print("Creating sample locations...")
    # Create sample locations
    sample_locations = [
        {
            "zone": "Western Railway",
            "division": "Mumbai Division",
            "section": "Mumbai-Pune Section",
            "station_code": "CSTM",
            "chainage": "1234/5-6",
            "track_number": "UP1",
            "gps_latitude": 18.9697,
            "gps_longitude": 72.8205
        },
        {
            "zone": "Southern Railway", 
            "division": "Chennai Division",
            "section": "Chennai-Bangalore Section",
            "station_code": "MAS",
            "chainage": "2345/7-8",
            "track_number": "DN2",
            "gps_latitude": 13.0843,
            "gps_longitude": 80.2705
        },
        {
            "zone": "Northern Railway",
            "division": "Delhi Division", 
            "section": "Delhi-Agra Section",
            "station_code": "NDLS",
            "chainage": "3456/9-10",
            "track_number": "UP3",
            "gps_latitude": 28.6431,
            "gps_longitude": 77.2197
        },
        {
            "zone": "Eastern Railway",
            "division": "Kolkata Division",
            "section": "Kolkata-Asansol Section", 
            "station_code": "KOAA",
            "chainage": "4567/11-12",
            "track_number": "DN1",
            "gps_latitude": 22.5675,
            "gps_longitude": 88.3918
        },
        {
            "zone": "Central Railway",
            "division": "Pune Division",
            "section": "Pune-Solapur Section",
            "station_code": "PUNE",
            "chainage": "5678/13-14", 
            "track_number": "UP2",
            "gps_latitude": 18.5204,
            "gps_longitude": 73.8567
        }
    ]
    
    locations = []
    for location_data in sample_locations:
        location = schemas.LocationCreate(**location_data)
        db_location = crud.create_location(db, location)
        locations.append(db_location)
    
    print("Creating sample components...")
    # Create sample components
    component_types = [
        models.ComponentType.ELASTIC_RAIL_CLIP,
        models.ComponentType.LINER,
        models.ComponentType.RAIL_PAD,
        models.ComponentType.SLEEPER
    ]
    
    component_statuses = [
        models.ComponentStatus.MANUFACTURED,
        models.ComponentStatus.SHIPPED,
        models.ComponentStatus.RECEIVED,
        models.ComponentStatus.INSTALLED,
        models.ComponentStatus.IN_SERVICE,
        models.ComponentStatus.MAINTENANCE,
        models.ComponentStatus.FAILED,
    ]
    
    components = []
    for i in range(500):  # Create 500 sample components
        component_type = random.choice(component_types)
        vendor = random.choice(vendors)
        location = random.choice(locations) if random.random() > 0.3 else None
        
        # Generate realistic dates
        mfg_date = fake.date_time_between(start_date='-2y', end_date='-1m')
        dispatch_date = mfg_date + timedelta(days=random.randint(1, 30))
        receiving_date = dispatch_date + timedelta(days=random.randint(1, 15))
        installation_date = receiving_date + timedelta(days=random.randint(1, 60)) if location else None
        warranty_start = mfg_date
        warranty_end = warranty_start + timedelta(days=random.randint(365, 1825))  # 1-5 years
        
        component_data = {
            "serial_id": f"{component_type.value.upper()[:3]}{vendor.vendor_code[-3:]}{i+1:06d}",
            "component_type": component_type,
            "material_specification": f"IS-{random.randint(1000, 9999)}-{random.randint(2015, 2023)}",
            "batch_number": f"B{random.randint(100, 999)}-{mfg_date.strftime('%Y%m')}",
            "lot_number": f"L{random.randint(10, 99)}-{mfg_date.strftime('%y%m%d')}",
            "po_number": f"PO/{vendor.vendor_code}/{random.randint(100, 999)}/23-24",
            "manufacturing_date": mfg_date,
            "dispatch_date": dispatch_date,
            "receiving_date": receiving_date,
            "installation_date": installation_date,
            "warranty_start_date": warranty_start,
            "warranty_end_date": warranty_end,
            "current_status": random.choice(component_statuses),
            "vendor_id": vendor.id,
            "location_id": location.id if location else None
        }
        
        component = schemas.ComponentCreate(**component_data)
        db_component = crud.create_component(db, component)
        components.append(db_component)
    
    print("Generating QR codes for components...")
    # Generate QR codes for first 50 components (for demo purposes)
    for component in components[:50]:
        try:
            generate_component_qr(component)
        except Exception as e:
            print(f"Error generating QR for {component.serial_id}: {e}")
    
    print("Creating sample inspections...")
    # Create sample inspections
    inspection_types = ["manufacturing", "receiving", "periodic", "maintenance", "failure"]
    inspection_statuses = [
        models.InspectionStatus.PASSED,
        models.InspectionStatus.FAILED,
        models.InspectionStatus.PENDING,
        models.InspectionStatus.MAINTENANCE_REQUIRED
    ]
    
    users = db.query(models.User).all()
    
    for i in range(200):  # Create 200 sample inspections
        component = random.choice(components)
        inspector = random.choice(users)
        
        inspection_date = fake.date_time_between(
            start_date=component.manufacturing_date,
            end_date='now'
        )
        
        status = random.choice(inspection_statuses)
        
        # Generate realistic findings based on status
        findings_templates = {
            models.InspectionStatus.PASSED: [
                "Component meets all specifications",
                "Visual inspection satisfactory", 
                "No defects observed",
                "All measurements within tolerance"
            ],
            models.InspectionStatus.FAILED: [
                "Crack observed in component body",
                "Dimensional deviation detected",
                "Surface corrosion present",
                "Material hardness below specification"
            ],
            models.InspectionStatus.MAINTENANCE_REQUIRED: [
                "Minor surface wear observed",
                "Lubrication required",
                "Cleaning needed",
                "Bolt torque adjustment required"
            ],
            models.InspectionStatus.PENDING: [
                "Awaiting test results",
                "Further investigation required",
                "Pending approval from supervisor"
            ]
        }
        
        inspection_data = {
            "component_id": component.id,
            "inspector_id": inspector.id,
            "inspection_type": random.choice(inspection_types),
            "inspection_date": inspection_date,
            "status": status,
            "findings": random.choice(findings_templates[status]),
            "recommendations": "Follow standard maintenance protocol" if status == models.InspectionStatus.MAINTENANCE_REQUIRED else None,
            "next_inspection_due": inspection_date + timedelta(days=random.randint(30, 180)),
            "severity_level": random.choice(["low", "medium", "high"]) if status == models.InspectionStatus.FAILED else "low"
        }
        
        inspection = schemas.InspectionCreate(**inspection_data)
        crud.create_inspection(db, inspection)
    
    print("Creating sample scan records...")
    # Create sample scan records
    scan_purposes = ["receiving", "inspection", "maintenance", "audit", "installation"]
    
    for i in range(300):  # Create 300 sample scan records
        component = random.choice(components)
        user = random.choice(users)
        
        scan_date = fake.date_time_between(
            start_date=component.receiving_date or component.manufacturing_date,
            end_date='now'
        )
        
        # Mock GPS coordinates near the component's location
        base_lat = component.location.gps_latitude if component.location else 28.6139  # Default to Delhi
        base_lon = component.location.gps_longitude if component.location else 77.2090
        
        scan_data = schemas.ScanData(
            scan_location=f"{component.location.station_code} - Track {component.location.track_number}" if component.location else "Depot",
            scan_purpose=random.choice(scan_purposes),
            gps_latitude=base_lat + random.uniform(-0.01, 0.01),
            gps_longitude=base_lon + random.uniform(-0.01, 0.01),
            device_info='{"device": "Android", "app_version": "1.0.0", "os_version": "11"}'
        )
        
        crud.create_scan_record(db, component.serial_id, scan_data)
    
    print("Creating sample purchase orders...")
    # Create sample purchase orders
    for vendor in vendors:
        for i in range(random.randint(2, 5)):  # 2-5 POs per vendor
            po_date = fake.date_time_between(start_date='-1y', end_date='-1m')
            delivery_date = po_date + timedelta(days=random.randint(30, 90))
            
            po_data = {
                "po_number": f"PO/{vendor.vendor_code}/{random.randint(100, 999)}/23-24",
                "vendor_id": vendor.id,
                "po_date": po_date,
                "delivery_date": delivery_date,
                "total_quantity": random.randint(1000, 10000),
                "unit_price": random.uniform(50, 500),
                "total_value": None,  # Will be calculated
                "status": random.choice(["active", "completed", "cancelled"]),
                "terms_conditions": "Standard railway procurement terms and conditions apply"
            }
            
            po_data["total_value"] = po_data["total_quantity"] * po_data["unit_price"]
            
            po = schemas.PurchaseOrderCreate(**po_data)
            crud.create_purchase_order(db, po)
    
    print("Creating sample quality metrics...")
    # Create sample quality metrics
    metric_names = [
        "Tensile Strength (MPa)",
        "Hardness (HRC)",
        "Surface Roughness (Ra)",
        "Dimensional Accuracy (%)",
        "Corrosion Resistance",
        "Fatigue Life (Cycles)"
    ]
    
    for vendor in vendors:
        for component_type in component_types:
            for metric_name in random.sample(metric_names, random.randint(3, 6)):
                metric_date = fake.date_time_between(start_date='-6m', end_date='now')
                
                # Generate realistic metric values
                if "Tensile Strength" in metric_name:
                    value = random.uniform(400, 800)
                    benchmark = 500
                elif "Hardness" in metric_name:
                    value = random.uniform(30, 60)
                    benchmark = 45
                elif "Surface Roughness" in metric_name:
                    value = random.uniform(0.5, 3.0)
                    benchmark = 1.6
                elif "Dimensional Accuracy" in metric_name:
                    value = random.uniform(95, 99.9)
                    benchmark = 98
                else:
                    value = random.uniform(80, 100)
                    benchmark = 90
                
                status = "within_spec" if value >= benchmark * 0.9 else "deviation"
                if value < benchmark * 0.7:
                    status = "critical"
                
                metric_data = {
                    "vendor_id": vendor.id,
                    "component_type": component_type,
                    "metric_name": metric_name,
                    "metric_value": round(value, 2),
                    "measurement_date": metric_date,
                    "benchmark_value": benchmark,
                    "status": status
                }
                
                metric = schemas.QualityMetricCreate(**metric_data)
                crud.create_quality_metric(db, metric)
    
    db.commit()
    print("Sample data population completed successfully!")
