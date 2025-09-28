import google.generativeai as genai
from sqlalchemy.orm import Session
from typing import Dict, Any, List
import json
from datetime import datetime
from . import models, crud

# Configure Gemini API
GEMINI_API_KEY = "AIzaSyAf4QCKba8EPriefkYoK3CWqfrLRH7pGxk"
genai.configure(api_key=GEMINI_API_KEY)

def generate_component_report(db: Session, component_id: str) -> Dict[str, Any]:
    """
    Generate a comprehensive report for a component using Google Gemini AI
    """
    try:
        # Get component data with all related information
        component = crud.get_component_by_serial(db, component_id)
        if not component:
            raise ValueError(f"Component {component_id} not found")
        
        # Get related data
        inspections = crud.get_inspections_by_component(db, component.id)
        scan_records = crud.get_scan_records_by_component(db, component.id)
        
        # Prepare data for AI analysis
        component_data = {
            "component_info": {
                "serial_id": component.serial_id,
                "component_type": component.component_type.value,
                "current_status": component.current_status.value,
                "material_specification": component.material_specification,
                "batch_number": component.batch_number,
                "lot_number": component.lot_number,
                "po_number": component.po_number,
                "manufacturing_date": component.manufacturing_date.isoformat() if component.manufacturing_date else None,
                "dispatch_date": component.dispatch_date.isoformat() if component.dispatch_date else None,
                "receiving_date": component.receiving_date.isoformat() if component.receiving_date else None,
                "installation_date": component.installation_date.isoformat() if component.installation_date else None,
                "warranty_start_date": component.warranty_start_date.isoformat() if component.warranty_start_date else None,
                "warranty_end_date": component.warranty_end_date.isoformat() if component.warranty_end_date else None,
            },
            "vendor_info": {
                "name": component.vendor.name if component.vendor else None,
                "vendor_code": component.vendor.vendor_code if component.vendor else None,
                "address": component.vendor.address if component.vendor else None,
                "contact_person": component.vendor.contact_person if component.vendor else None,
                "phone": component.vendor.phone if component.vendor else None,
                "email": component.vendor.email if component.vendor else None,
                "certification_status": component.vendor.certification_status if component.vendor else None,
                "quality_rating": component.vendor.quality_rating if component.vendor else None,
            },
            "location_info": {
                "zone": component.location.zone if component.location else None,
                "division": component.location.division if component.location else None,
                "section": component.location.section if component.location else None,
                "station_code": component.location.station_code if component.location else None,
                "chainage": component.location.chainage if component.location else None,
                "track_number": component.location.track_number if component.location else None,
                "gps_latitude": component.location.gps_latitude if component.location else None,
                "gps_longitude": component.location.gps_longitude if component.location else None,
            },
            "inspections": [
                {
                    "inspection_type": inspection.inspection_type,
                    "inspection_date": inspection.inspection_date.isoformat(),
                    "status": inspection.status.value,
                    "findings": inspection.findings,
                    "recommendations": inspection.recommendations,
                    "next_inspection_due": inspection.next_inspection_due.isoformat() if inspection.next_inspection_due else None,
                    "defect_category": inspection.defect_category,
                    "severity_level": inspection.severity_level,
                    "measurements": inspection.measurements,
                }
                for inspection in inspections
            ],
            "scan_records": [
                {
                    "scan_location": scan.scan_location,
                    "scan_purpose": scan.scan_purpose,
                    "timestamp": scan.timestamp.isoformat(),
                    "gps_latitude": scan.gps_latitude,
                    "gps_longitude": scan.gps_longitude,
                }
                for scan in scan_records
            ]
        }
        
        # Create the prompt for Gemini
        prompt = f"""
        You are an expert railway engineer analyzing track fitting components for Indian Railways. 
        Generate a comprehensive technical report for the following component data:

        Component Data:
        {json.dumps(component_data, indent=2)}

        Please provide a detailed report that includes:

        1. **Executive Summary**: Brief overview of the component's current status and key findings
        2. **Component Details**: Technical specifications, manufacturing info, and current status
        3. **Vendor Information**: Manufacturer details, quality ratings, and certification status
        4. **Location Details**: Installation location, track information, and GPS coordinates
        5. **Inspection History**: Summary of all inspections, findings, and recommendations
        6. **Scan Records**: Tracking history and location scans
        7. **Quality Assessment**: Overall quality rating based on inspections and performance
        8. **Maintenance Recommendations**: Specific actions needed based on inspection findings
        9. **Risk Assessment**: Potential risks and their severity levels
        10. **Compliance Status**: Adherence to railway standards and regulations

        Format the report in a professional, technical style suitable for railway engineers and management.
        Include specific dates, measurements, and actionable recommendations.
        Highlight any critical issues that require immediate attention.
        """
        
        # Generate the report using Gemini
        model = genai.GenerativeModel('gemini-2.0-flash')
        response = model.generate_content(prompt)
        
        # Parse the response
        report_content = response.text
        
        # Create structured report data
        report_data = {
            "component_id": component_id,
            "generated_at": datetime.now().isoformat(),
            "report_content": report_content,
            "component_summary": {
                "serial_id": component.serial_id,
                "type": component.component_type.value,
                "status": component.current_status.value,
                "vendor": component.vendor.name if component.vendor else "Unknown",
                "location": f"{component.location.zone} - {component.location.division}" if component.location else "Not assigned",
                "total_inspections": len(inspections),
                "last_inspection": max([i.inspection_date for i in inspections]).isoformat() if inspections else None,
            },
            "raw_data": component_data
        }
        
        return report_data
        
    except Exception as e:
        return {
            "error": f"Failed to generate report: {str(e)}",
            "component_id": component_id,
            "generated_at": datetime.now().isoformat()
        }

def generate_bulk_report(db: Session, component_ids: List[str]) -> Dict[str, Any]:
    """
    Generate a bulk report for multiple components
    """
    try:
        reports = []
        for component_id in component_ids:
            report = generate_component_report(db, component_id)
            reports.append(report)
        
        # Generate summary using Gemini
        summary_prompt = f"""
        You are analyzing multiple railway track fitting components. Generate a summary report for the following components:

        {json.dumps([r.get('component_summary', {}) for r in reports], indent=2)}

        Provide:
        1. Overall system health assessment
        2. Common issues across components
        3. Vendor performance summary
        4. Location-based insights
        5. Priority maintenance recommendations
        6. Risk assessment summary
        """
        
        model = genai.GenerativeModel('gemini-2.0-flash')
        response = model.generate_content(summary_prompt)
        
        return {
            "bulk_report": response.text,
            "individual_reports": reports,
            "generated_at": datetime.now().isoformat(),
            "total_components": len(component_ids)
        }
        
    except Exception as e:
        return {
            "error": f"Failed to generate bulk report: {str(e)}",
            "generated_at": datetime.now().isoformat()
        }
