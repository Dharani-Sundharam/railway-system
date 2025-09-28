import qrcode
from PIL import Image
import os
from PIL import Image, ImageDraw, ImageFont
from . import models

def generate_component_qr(component: models.Component, base_url: str = "https://rail.id/i/") -> str:
    """
    Generate QR code for a railway component
    
    Args:
        component: Component model instance
        base_url: Base URL for the QR code
        
    Returns:
        Path to the generated QR code image
    """
    
    # Create QR data - using a URL format for mobile scanning
    qr_data = f"{base_url}{component.serial_id}"
    
    # Create QR code instance
    qr = qrcode.QRCode(
        version=1,  # Controls the size (1 is smallest)
        error_correction=qrcode.constants.ERROR_CORRECT_H,  # High error correction (30%)
        box_size=10,
        border=4,
    )
    
    # Add data to QR code
    qr.add_data(qr_data)
    qr.make(fit=True)
    
    # Create QR code image with basic styling
    img = qr.make_image(
        fill_color="black",
        back_color="white"
    )
    
    # Create a larger canvas for additional information
    canvas_width = 400
    canvas_height = 500
    canvas = Image.new('RGB', (canvas_width, canvas_height), 'white')
    
    # Resize QR code to fit canvas
    qr_size = 300
    img = img.resize((qr_size, qr_size), Image.Resampling.LANCZOS)
    
    # Paste QR code on canvas
    qr_x = (canvas_width - qr_size) // 2
    qr_y = 50
    canvas.paste(img, (qr_x, qr_y))
    
    # Add text information
    draw = ImageDraw.Draw(canvas)
    
    try:
        # Try to use a better font
        title_font = ImageFont.truetype("arial.ttf", 16)
        info_font = ImageFont.truetype("arial.ttf", 12)
        small_font = ImageFont.truetype("arial.ttf", 10)
    except:
        # Fallback to default font
        title_font = ImageFont.load_default()
        info_font = ImageFont.load_default()
        small_font = ImageFont.load_default()
    
    # Title
    title = "Indian Railways - Track Fitting"
    title_bbox = draw.textbbox((0, 0), title, font=title_font)
    title_width = title_bbox[2] - title_bbox[0]
    title_x = (canvas_width - title_width) // 2
    draw.text((title_x, 10), title, fill="black", font=title_font)
    
    # Component information below QR code
    info_y = qr_y + qr_size + 20
    
    # Component details
    details = [
        f"Serial ID: {component.serial_id}",
        f"Type: {component.component_type.value.replace('_', ' ').title()}",
        f"Status: {component.current_status.value.replace('_', ' ').title()}",
    ]
    
    if component.batch_number:
        details.append(f"Batch: {component.batch_number}")
    
    if component.manufacturing_date:
        details.append(f"Mfg Date: {component.manufacturing_date.strftime('%Y-%m-%d')}")
    
    if component.warranty_end_date:
        details.append(f"Warranty Until: {component.warranty_end_date.strftime('%Y-%m-%d')}")
    
    # Draw details
    for i, detail in enumerate(details):
        detail_bbox = draw.textbbox((0, 0), detail, font=info_font)
        detail_width = detail_bbox[2] - detail_bbox[0]
        detail_x = (canvas_width - detail_width) // 2
        draw.text((detail_x, info_y + i * 20), detail, fill="black", font=info_font)
    
    # Add URL at the bottom
    url_y = canvas_height - 30
    url_text = qr_data
    url_bbox = draw.textbbox((0, 0), url_text, font=small_font)
    url_width = url_bbox[2] - url_bbox[0]
    url_x = (canvas_width - url_width) // 2
    draw.text((url_x, url_y), url_text, fill="gray", font=small_font)
    
    # Ensure directory exists
    qr_dir = "static/qr_codes"
    os.makedirs(qr_dir, exist_ok=True)
    
    # Save the image
    filename = f"{component.serial_id}.png"
    filepath = os.path.join(qr_dir, filename)
    canvas.save(filepath, "PNG", quality=95)
    
    # Update component with QR code path
    component.qr_code_path = filepath
    
    return filepath

def generate_bulk_qr_codes(components: list[models.Component], base_url: str = "https://rail.id/i/") -> list[str]:
    """
    Generate QR codes for multiple components
    
    Args:
        components: List of component model instances
        base_url: Base URL for the QR codes
        
    Returns:
        List of paths to generated QR code images
    """
    paths = []
    for component in components:
        path = generate_component_qr(component, base_url)
        paths.append(path)
    return paths

def generate_simple_qr(data: str, filename: str = None) -> str:
    """
    Generate a simple QR code for any data
    
    Args:
        data: Data to encode in QR code
        filename: Optional filename (auto-generated if not provided)
        
    Returns:
        Path to the generated QR code image
    """
    qr = qrcode.QRCode(
        version=1,
        error_correction=qrcode.constants.ERROR_CORRECT_M,
        box_size=10,
        border=4,
    )
    
    qr.add_data(data)
    qr.make(fit=True)
    
    img = qr.make_image(fill_color="black", back_color="white")
    
    # Ensure directory exists
    qr_dir = "static/qr_codes"
    os.makedirs(qr_dir, exist_ok=True)
    
    # Generate filename if not provided
    if not filename:
        import hashlib
        filename = hashlib.md5(data.encode()).hexdigest()[:10] + ".png"
    
    filepath = os.path.join(qr_dir, filename)
    img.save(filepath)
    
    return filepath

def verify_qr_readability(filepath: str) -> dict:
    """
    Verify QR code readability and return quality metrics
    
    Args:
        filepath: Path to QR code image
        
    Returns:
        Dictionary with quality metrics
    """
    try:
        from pyzbar import pyzbar
        import cv2
        
        # Read the image
        image = cv2.imread(filepath)
        
        # Decode QR codes in the image
        decoded_objects = pyzbar.decode(image)
        
        if decoded_objects:
            decoded_data = decoded_objects[0].data.decode('utf-8')
            return {
                "readable": True,
                "data": decoded_data,
                "quality": "good"
            }
        else:
            return {
                "readable": False,
                "data": None,
                "quality": "poor"
            }
    except ImportError:
        # pyzbar not installed, return basic info
        return {
            "readable": True,  # Assume readable
            "data": "verification_not_available",
            "quality": "unknown"
        }
    except Exception as e:
        return {
            "readable": False,
            "data": None,
            "quality": "error",
            "error": str(e)
        }
