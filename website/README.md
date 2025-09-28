# Indian Railways Track Fittings Management System

A comprehensive system for laser-based QR code marking and tracking of railway track fittings, built for Smart India Hackathon 2025.

## 🚂 Overview

This system provides end-to-end tracking of railway track fittings including:
- **10+ crore Elastic Rail Clips** annually
- **5+ crore Liners** annually  
- **8.5+ crore Rail Pads** annually
- **Concrete Sleepers**

### Key Features

- **QR Code Generation**: Laser-based QR code marking for durable component identification
- **Mobile Scanning**: React Native app for field QR code scanning and inspections
- **Web Dashboard**: Comprehensive analytics and management interface
- **API Integration**: RESTful APIs for UDM and TMS portal integration
- **AI Analytics**: Performance insights and predictive maintenance
- **Offline Support**: Mobile app works without internet connectivity

## 🏗️ Architecture

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Mobile App    │    │   Web Frontend   │    │  External APIs  │
│  (React Native)│    │     (React)      │    │  (UDM/TMS)     │
└─────────┬───────┘    └─────────┬────────┘    └─────────┬───────┘
          │                      │                       │
          └──────────────────────┼───────────────────────┘
                                 │
                    ┌────────────┴────────────┐
                    │     API Gateway         │
                    │    (FastAPI + Auth)     │
                    └────────────┬────────────┘
                                 │
                    ┌────────────┴────────────┐
                    │     Core Services       │
                    │  - Component Management │
                    │  - QR Code Generation   │
                    │  - Analytics Engine     │
                    │  - Inspection Tracking  │
                    └────────────┬────────────┘
                                 │
                    ┌────────────┴────────────┐
                    │      Database           │
                    │     (SQLite)            │
                    └─────────────────────────┘
```

## 🛠️ Technology Stack

### Backend
- **FastAPI**: Modern Python web framework
- **SQLAlchemy**: ORM for database operations
- **SQLite**: Embedded database
- **Pydantic**: Data validation
- **Python-Jose**: JWT authentication
- **QRCode**: QR code generation library

### Frontend
- **React 18**: Modern UI framework
- **TypeScript**: Type-safe JavaScript
- **Tailwind CSS**: Utility-first CSS framework
- **React Query**: Data fetching and caching
- **React Router**: Client-side routing
- **Recharts**: Data visualization

### Mobile
- **React Native**: Cross-platform mobile development
- **Expo**: Development platform and tools
- **React Native Paper**: Material Design components
- **Expo Camera**: QR code scanning
- **Expo Location**: GPS tracking

### DevOps
- **Nginx**: Reverse proxy and load balancer
- **SQLite**: Embedded database for easy deployment

## 🚀 Quick Start

### Prerequisites
- Node.js 18+ (for local development)
- Python 3.11+ (for local development)

### 1. Clone the Repository
```bash
git clone <repository-url>
cd railway-fittings-system
```

### 2. Start the Backend
```bash
cd backend
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate
pip install -r requirements.txt
uvicorn app.main:app --reload
```

### 3. Start the Frontend
```bash
cd frontend
npm install
npm start
```

### 4. Access the Applications
- **Web Dashboard**: http://localhost:3000
- **API Documentation**: http://localhost:8000/docs
- **Database**: SQLite file (railway_fittings.db)

### 5. Demo Credentials
| Role | Username | Password |
|------|----------|----------|
| Admin | `admin` | `admin123` |
| Inspector | `inspector1` | `inspector123` |
| Depot Manager | `depot_manager` | `depot123` |

## 📱 Mobile App Setup

### For Development
```bash
cd mobile
npm install
npm start

# For Android
npm run android

# For iOS  
npm run ios
```

### For Production Build
```bash
# Android APK
expo build:android

# iOS IPA
expo build:ios
```

## 🔧 Local Development

### Backend Setup
```bash
cd backend
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate
pip install -r requirements.txt
uvicorn app.main:app --reload
```

### Frontend Setup
```bash
cd frontend
npm install
npm start
```

### Database Setup
```bash
# SQLite database is automatically created
# Database file: railway_fittings.db
```

## 📊 Sample Data

The system automatically populates sample data on first startup:
- **500+ Components** across all types
- **5 Vendors** with realistic details
- **5 Locations** across different railway zones
- **200+ Inspections** with various statuses
- **300+ Scan Records** with GPS coordinates

## 🔌 API Integration

### UDM Portal Integration
```python
# Example: Sync component data with UDM
POST /api/components/
{
  "serial_id": "ERC001234",
  "component_type": "elastic_rail_clip",
  "vendor_id": 1,
  "po_number": "PO/RAIL001/123/23-24"
}
```

### TMS Portal Integration
```python
# Example: Update component location in TMS
PUT /api/components/ERC001234/location
{
  "zone": "Western Railway",
  "division": "Mumbai Division",
  "chainage": "1234/5-6"
}
```

## 📈 Analytics & Reporting

### Dashboard Metrics
- Component distribution by type and status
- Vendor performance analytics
- Quality ratings and failure rates
- Recent inspection trends

### AI Features
- Predictive maintenance scheduling
- Anomaly detection in component performance
- Automated quality scoring
- Vendor performance benchmarking

## 🔒 Security Features

- **JWT Authentication**: Secure API access
- **Role-based Access Control**: Different permissions for different user roles
- **Rate Limiting**: API protection against abuse
- **Data Encryption**: Sensitive data protection
- **Audit Trails**: Complete action logging

## 📋 QR Code Specifications

### Technical Details
- **Standard**: ISO/IEC 18004
- **Error Correction**: Level H (30% recovery)
- **Module Size**: 0.5mm minimum
- **Overall Size**: 15mm x 15mm to 25mm x 25mm
- **Data Format**: `https://rail.id/i/{serial_id}`

### Laser Marking Requirements
- **Steel Components**: Fiber laser (1064 nm)
- **Polymer Components**: UV laser (355 nm)
- **Concrete Sleepers**: CO2 laser or embedded plates
- **Durability**: Weather-resistant, impact-resistant

## 🔄 Deployment

### Production Deployment
1. **Configure Environment Variables**
   ```bash
   cp .env.example .env
   # Edit .env with production values
   ```

2. **SSL Certificates**
   ```bash
   # Place SSL certificates in ./ssl/ directory
   # Update nginx.conf for HTTPS
   ```

3. **Deploy with Docker Compose**
   ```bash
   docker-compose -f docker-compose.prod.yml up -d
   ```

### Cloud Deployment Options
- **AWS**: ECS, RDS, S3, CloudFront
- **Google Cloud**: Cloud Run, Cloud SQL, Cloud Storage
- **Azure**: Container Instances, Azure Database, Blob Storage
- **Railway**: Simple deployment with Railway.app

## 📚 API Documentation

### Authentication
```bash
# Login
curl -X POST http://localhost:8000/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin123"}'

# Use token in subsequent requests
curl -H "Authorization: Bearer <token>" \
  http://localhost:8000/components/
```

### Component Management
```bash
# Get all components
GET /components/

# Get component by ID
GET /components/{serial_id}

# Create component
POST /components/

# Generate QR code
POST /components/{serial_id}/qr
```

### Inspection Management
```bash
# Create inspection
POST /inspections/

# Get inspections
GET /inspections/

# Scan component
POST /scan/{serial_id}
```

## 🧪 Testing

### Backend Tests
```bash
cd backend
pytest tests/ -v
```

### Frontend Tests
```bash
cd frontend
npm test
```

### Mobile Tests
```bash
cd mobile
npm test
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📄 License

This project is developed for Smart India Hackathon 2025 and Indian Railways.

## 🆘 Support

For technical support or questions:
- Create an issue in the repository
- Contact the development team
- Refer to the API documentation at `/docs`

## 🎯 Roadmap

### Phase 1 (Current)
- ✅ Basic QR code generation and scanning
- ✅ Component and vendor management
- ✅ Mobile app with offline support
- ✅ Web dashboard with analytics

### Phase 2 (Planned)
- [ ] Advanced AI analytics and predictions
- [ ] Integration with actual UDM/TMS portals
- [ ] Batch QR code printing support
- [ ] Advanced reporting and exports

### Phase 3 (Future)
- [ ] IoT sensor integration
- [ ] Blockchain-based authenticity verification
- [ ] Advanced computer vision for defect detection
- [ ] Multi-language support

---

**Built with ❤️ for Indian Railways and Smart India Hackathon 2025**
