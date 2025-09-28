# Deployment Guide

This guide covers different deployment options for the Indian Railways Track Fittings Management System.

## 🚀 Quick Deployment

### Prerequisites
- Python 3.11+
- Node.js 18+
- 2GB RAM minimum
- 5GB disk space

### Steps

1. **Clone and Setup**
   ```bash
   git clone <repository-url>
   cd railway-fittings-system
   cp env.example .env
   ```

2. **Configure Environment**
   ```bash
   # Edit .env file with your settings
   nano .env
   ```

3. **Start Backend**
   ```bash
   cd backend
   python -m venv venv
   source venv/bin/activate
   pip install -r requirements.txt
   uvicorn app.main:app --host 0.0.0.0 --port 8000
   ```

4. **Start Frontend**
   ```bash
   cd frontend
   npm install
   npm run build
   npm start
   ```

5. **Access Applications**
   - Web Dashboard: http://localhost:3000
   - API Docs: http://localhost:8000/docs
   - Database: SQLite file (railway_fittings.db)

## 🔧 Local Development Setup

### Backend Development
```bash
cd backend
python -m venv venv
source venv/bin/activate  # Windows: venv\Scripts\activate
pip install -r requirements.txt

# Set environment variables
export DATABASE_URL="sqlite:///./railway_fittings.db"
export SECRET_KEY="your-secret-key"

# Run development server
uvicorn app.main:app --reload --host 0.0.0.0 --port 8000
```

### Frontend Development
```bash
cd frontend
npm install

# Set environment variables
export REACT_APP_API_URL="http://localhost:8000"

# Run development server
npm start
```

### Mobile Development
```bash
cd mobile
npm install

# Start Expo development server
npm start

# Run on Android
npm run android

# Run on iOS
npm run ios
```

## ☁️ Cloud Deployment Options

### 1. Railway.app (Recommended for Demo)

Railway.app provides simple deployment with automatic HTTPS and domain.

```bash
# Install Railway CLI
npm install -g @railway/cli

# Login and deploy
railway login
railway init
railway up
```

**railway.json:**
```json
{
  "$schema": "https://railway.app/railway.schema.json",
  "build": {
    "builder": "DOCKERFILE",
    "dockerfilePath": "Dockerfile"
  },
  "deploy": {
    "startCommand": "uvicorn app.main:app --host 0.0.0.0 --port $PORT",
    "healthcheckPath": "/",
    "healthcheckTimeout": 100,
    "restartPolicyType": "ON_FAILURE",
    "restartPolicyMaxRetries": 10
  }
}
```

### 2. AWS Deployment

#### Using AWS ECS (Elastic Container Service)

1. **Build and Push Images**
   ```bash
   # Build images
   docker build -t railway-backend ./backend
   docker build -t railway-frontend ./frontend

   # Tag for ECR
   docker tag railway-backend:latest <account-id>.dkr.ecr.<region>.amazonaws.com/railway-backend:latest
   docker tag railway-frontend:latest <account-id>.dkr.ecr.<region>.amazonaws.com/railway-frontend:latest

   # Push to ECR
   docker push <account-id>.dkr.ecr.<region>.amazonaws.com/railway-backend:latest
   docker push <account-id>.dkr.ecr.<region>.amazonaws.com/railway-frontend:latest
   ```

2. **Create ECS Task Definition**
   ```json
   {
     "family": "railway-fittings",
     "networkMode": "awsvpc",
     "requiresCompatibilities": ["FARGATE"],
     "cpu": "512",
     "memory": "1024",
     "executionRoleArn": "arn:aws:iam::<account-id>:role/ecsTaskExecutionRole",
     "containerDefinitions": [
       {
         "name": "backend",
         "image": "<account-id>.dkr.ecr.<region>.amazonaws.com/railway-backend:latest",
         "portMappings": [
           {
             "containerPort": 8000,
             "protocol": "tcp"
           }
         ],
         "environment": [
           {
             "name": "DATABASE_URL",
             "value": "postgresql://user:pass@rds-endpoint:5432/railway_fittings"
           }
         ]
       }
     ]
   }
   ```

3. **Setup RDS Database**
   ```bash
   aws rds create-db-instance \
     --db-instance-identifier railway-fittings-db \
     --db-instance-class db.t3.micro \
     --engine postgres \
     --master-username railway_user \
     --master-user-password your-password \
     --allocated-storage 20
   ```

### 3. Google Cloud Platform

#### Using Cloud Run

1. **Build and Deploy Backend**
   ```bash
   # Enable required APIs
   gcloud services enable run.googleapis.com
   gcloud services enable sql-component.googleapis.com

   # Build and deploy
   cd backend
   gcloud run deploy railway-backend \
     --source . \
     --platform managed \
     --region us-central1 \
     --allow-unauthenticated
   ```

2. **Setup Cloud SQL**
   ```bash
   # Create PostgreSQL instance
   gcloud sql instances create railway-db \
     --database-version POSTGRES_13 \
     --tier db-f1-micro \
     --region us-central1

   # Create database
   gcloud sql databases create railway_fittings \
     --instance railway-db
   ```

### 4. Microsoft Azure

#### Using Container Instances

1. **Create Resource Group**
   ```bash
   az group create --name railway-fittings --location eastus
   ```

2. **Deploy Container**
   ```bash
   az container create \
     --resource-group railway-fittings \
     --name railway-backend \
     --image your-registry/railway-backend:latest \
     --dns-name-label railway-fittings \
     --ports 8000 \
     --environment-variables \
       DATABASE_URL="postgresql://user:pass@server:5432/db"
   ```

## 🔒 Production Security Checklist

### Environment Security
- [ ] Change default passwords and secrets
- [ ] Use strong JWT secret keys (32+ characters)
- [ ] Enable HTTPS/TLS encryption
- [ ] Configure proper CORS origins
- [ ] Set up rate limiting
- [ ] Enable database SSL connections

### Infrastructure Security
- [ ] Use private networks for database access
- [ ] Configure firewall rules
- [ ] Set up monitoring and alerting
- [ ] Enable audit logging
- [ ] Regular security updates
- [ ] Backup and disaster recovery plan

### Application Security
- [ ] Input validation and sanitization
- [ ] SQL injection protection (SQLAlchemy ORM)
- [ ] XSS protection headers
- [ ] CSRF protection
- [ ] File upload restrictions
- [ ] API authentication and authorization

## 📊 Monitoring and Logging

### Application Monitoring
```python
# Add to backend/app/main.py
import logging
from prometheus_client import Counter, Histogram, generate_latest

# Metrics
REQUEST_COUNT = Counter('http_requests_total', 'Total HTTP requests', ['method', 'endpoint'])
REQUEST_LATENCY = Histogram('http_request_duration_seconds', 'HTTP request latency')

@app.middleware("http")
async def add_process_time_header(request: Request, call_next):
    start_time = time.time()
    response = await call_next(request)
    process_time = time.time() - start_time
    response.headers["X-Process-Time"] = str(process_time)
    REQUEST_LATENCY.observe(process_time)
    REQUEST_COUNT.labels(method=request.method, endpoint=request.url.path).inc()
    return response
```

### Log Aggregation
```yaml
# docker-compose.logging.yml
version: '3.8'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.5.0
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
    ports:
      - "9200:9200"

  kibana:
    image: docker.elastic.co/kibana/kibana:8.5.0
    ports:
      - "5601:5601"
    environment:
      - ELASTICSEARCH_HOSTS=http://elasticsearch:9200

  logstash:
    image: docker.elastic.co/logstash/logstash:8.5.0
    volumes:
      - ./logstash.conf:/usr/share/logstash/pipeline/logstash.conf
```

## 🔄 CI/CD Pipeline

### GitHub Actions Example
```yaml
# .github/workflows/deploy.yml
name: Deploy to Production

on:
  push:
    branches: [main]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Run tests
        run: |
          cd backend
          python -m pytest tests/

  build-and-deploy:
    needs: test
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      
      - name: Build Docker images
        run: |
          docker build -t railway-backend ./backend
          docker build -t railway-frontend ./frontend
      
      - name: Deploy to production
        run: |
          # Add your deployment commands here
          echo "Deploying to production..."
```

## 📱 Mobile App Deployment

### Android APK Build
```bash
cd mobile

# Install EAS CLI
npm install -g @expo/eas-cli

# Login to Expo
eas login

# Configure build
eas build:configure

# Build APK
eas build --platform android --profile production

# Submit to Play Store (optional)
eas submit --platform android
```

### iOS App Build
```bash
# Build for iOS
eas build --platform ios --profile production

# Submit to App Store (optional)
eas submit --platform ios
```

## 🔧 Database Migration and Backup

### Database Migration
```bash
# Create migration
cd backend
alembic revision --autogenerate -m "Add new table"

# Apply migration
alembic upgrade head

# Rollback migration
alembic downgrade -1
```

### Automated Backup Script
```bash
#!/bin/bash
# backup.sh

DATE=$(date +%Y%m%d_%H%M%S)
BACKUP_DIR="/backups"
DB_NAME="railway_fittings"

# Create backup
pg_dump $DATABASE_URL > $BACKUP_DIR/backup_$DATE.sql

# Upload to S3 (optional)
aws s3 cp $BACKUP_DIR/backup_$DATE.sql s3://railway-backups/

# Clean old backups (keep 30 days)
find $BACKUP_DIR -name "backup_*.sql" -mtime +30 -delete
```

### Cron Job for Automated Backup
```bash
# Add to crontab
0 2 * * * /path/to/backup.sh
```

## 🚨 Troubleshooting

### Common Issues

1. **Database Connection Failed**
   ```bash
   # Check database status
   docker-compose ps db
   
   # View database logs
   docker-compose logs db
   
   # Test connection
   psql $DATABASE_URL -c "SELECT 1;"
   ```

2. **API Not Responding**
   ```bash
   # Check backend logs
   docker-compose logs backend
   
   # Test API endpoint
   curl http://localhost:8000/
   
   # Check container health
   docker-compose ps
   ```

3. **Frontend Build Errors**
   ```bash
   # Clear npm cache
   cd frontend
   npm cache clean --force
   
   # Delete node_modules and reinstall
   rm -rf node_modules package-lock.json
   npm install
   ```

4. **Mobile App Issues**
   ```bash
   # Clear Expo cache
   cd mobile
   expo r -c
   
   # Reset Metro bundler
   npx react-native start --reset-cache
   ```

### Performance Optimization

1. **Database Optimization**
   ```sql
   -- Add indexes for common queries
   CREATE INDEX idx_components_serial_id ON components(serial_id);
   CREATE INDEX idx_components_vendor_type ON components(vendor_id, component_type);
   CREATE INDEX idx_inspections_date ON inspections(inspection_date DESC);
   ```

2. **API Optimization**
   ```python
   # Add caching
   from fastapi_cache import FastAPICache
   from fastapi_cache.backends.redis import RedisBackend
   
   @app.on_event("startup")
   async def startup():
       redis = aioredis.from_url("redis://localhost")
       FastAPICache.init(RedisBackend(redis), prefix="fastapi-cache")
   ```

3. **Frontend Optimization**
   ```javascript
   // Code splitting
   const ComponentDetail = lazy(() => import('./pages/ComponentDetail'));
   
   // Memoization
   const ExpensiveComponent = memo(({ data }) => {
     return <div>{/* expensive rendering */}</div>;
   });
   ```

## 📞 Support and Maintenance

### Health Checks
- API Health: `GET /health`
- Database Health: `SELECT 1;`
- Frontend Health: HTTP 200 response
- Mobile App: Crash reporting with Sentry

### Monitoring Endpoints
- Metrics: `GET /metrics` (Prometheus format)
- Status: `GET /status`
- Version: `GET /version`

### Log Levels
- **DEBUG**: Detailed debugging information
- **INFO**: General information about system operation
- **WARNING**: Warning messages for unusual situations
- **ERROR**: Error messages for serious problems
- **CRITICAL**: Critical errors that may cause system failure

---

For additional support, please refer to the main README.md or create an issue in the repository.
