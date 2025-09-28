# Railway System Deployment on Render

This guide will help you deploy the Indian Railways Track Fittings Management System on Render.com.

## 🚀 Prerequisites

1. **Render Account**: Sign up at [render.com](https://render.com)
2. **GitHub Repository**: Push your code to GitHub
3. **Domain (Optional)**: Custom domain for production

## 📋 Deployment Steps

### Step 1: Prepare Your Repository

1. **Push to GitHub**:
   ```bash
   git add .
   git commit -m "Add Render deployment configuration"
   git push origin main
   ```

2. **Verify Files**: Ensure these files are in your repository:
   - `render.yaml` (in website/ directory)
   - `backend/Dockerfile`
   - `frontend/Dockerfile`
   - `frontend/nginx.conf`

### Step 2: Create Render Services

#### Option A: Using Blueprint (Recommended)

1. **Connect GitHub**:
   - Go to [render.com](https://render.com)
   - Click "New +" → "Blueprint"
   - Connect your GitHub repository
   - Select your repository

2. **Deploy Blueprint**:
   - Render will detect the `render.yaml` file
   - Review the services configuration
   - Click "Apply" to create all services

#### Option B: Manual Setup

1. **Create PostgreSQL Database**:
   - Go to Render Dashboard
   - Click "New +" → "PostgreSQL"
   - Name: `railway-db`
   - Plan: `Starter` (Free tier)
   - Region: Choose closest to your users
   - Click "Create Database"

2. **Create Backend Service**:
   - Click "New +" → "Web Service"
   - Connect your GitHub repository
   - Configure:
     - **Name**: `railway-backend`
     - **Environment**: `Python 3`
     - **Build Command**: `pip install -r requirements.txt`
     - **Start Command**: `uvicorn app.main:app --host 0.0.0.0 --port $PORT`
     - **Root Directory**: `website/backend`

3. **Create Frontend Service**:
   - Click "New +" → "Static Site"
   - Connect your GitHub repository
   - Configure:
     - **Name**: `railway-frontend`
     - **Root Directory**: `website/frontend`
     - **Build Command**: `npm install && npm run build`
     - **Publish Directory**: `build`

### Step 3: Configure Environment Variables

#### Backend Environment Variables

In your backend service settings, add these environment variables:

```bash
# Database
DATABASE_URL=<from PostgreSQL service>

# Security
SECRET_KEY=<generate a strong secret key>
ALGORITHM=HS256
ACCESS_TOKEN_EXPIRE_MINUTES=30

# Application
DEBUG=false
CORS_ORIGINS=https://railway-frontend.onrender.com
ALLOWED_HOSTS=railway-backend.onrender.com

# File Storage
UPLOAD_FOLDER=./static/uploads
QR_CODE_FOLDER=./static/qr_codes
MAX_FILE_SIZE=10485760
```

#### Frontend Environment Variables

In your frontend service settings, add:

```bash
REACT_APP_API_URL=https://railway-backend.onrender.com
REACT_APP_APP_NAME=Railway Fittings Management System
```

### Step 4: Database Setup

1. **Get Database URL**:
   - Go to your PostgreSQL service
   - Copy the "External Database URL"
   - Use this as your `DATABASE_URL` environment variable

2. **Initialize Database**:
   - The backend will automatically create tables on first startup
   - Sample data will be populated automatically

### Step 5: Custom Domain (Optional)

1. **Add Custom Domain**:
   - Go to your service settings
   - Click "Custom Domains"
   - Add your domain
   - Update DNS records as instructed

2. **Update Environment Variables**:
   - Update `CORS_ORIGINS` with your custom domain
   - Update `ALLOWED_HOSTS` with your custom domain

## 🔧 Configuration Details

### Backend Configuration

The backend service will:
- Run on Python 3.11
- Use PostgreSQL database
- Serve API endpoints at `/`
- Handle CORS for frontend
- Generate QR codes in `/static/qr_codes`

### Frontend Configuration

The frontend service will:
- Build React application
- Serve static files via Nginx
- Proxy API calls to backend
- Handle client-side routing

### Database Configuration

The PostgreSQL database will:
- Store all application data
- Support concurrent connections
- Provide automatic backups
- Scale with your application

## 🚨 Troubleshooting

### Common Issues

1. **Build Failures**:
   ```bash
   # Check build logs in Render dashboard
   # Common fixes:
   - Update requirements.txt
   - Check Python version compatibility
   - Verify file paths
   ```

2. **Database Connection Issues**:
   ```bash
   # Verify DATABASE_URL format:
   postgresql://user:password@host:port/database
   
   # Check database service status
   # Ensure database is running
   ```

3. **CORS Issues**:
   ```bash
   # Update CORS_ORIGINS environment variable
   # Include both frontend URL and custom domain
   ```

4. **Static Files Not Loading**:
   ```bash
   # Check nginx.conf configuration
   # Verify static file paths
   # Check file permissions
   ```

### Performance Optimization

1. **Enable Caching**:
   - Static files are cached by default
   - API responses can be cached with Redis

2. **Database Optimization**:
   - Add indexes for common queries
   - Use connection pooling
   - Monitor query performance

3. **Frontend Optimization**:
   - Enable gzip compression
   - Use CDN for static assets
   - Implement lazy loading

## 📊 Monitoring

### Health Checks

- **Backend**: `GET /` returns 200 OK
- **Frontend**: Static files serve correctly
- **Database**: Connection successful

### Logs

- View logs in Render dashboard
- Monitor error rates
- Track performance metrics

### Alerts

- Set up alerts for service downtime
- Monitor database connections
- Track response times

## 🔒 Security Considerations

### Production Security

1. **Environment Variables**:
   - Use strong SECRET_KEY (32+ characters)
   - Rotate database passwords regularly
   - Never commit secrets to repository

2. **CORS Configuration**:
   - Restrict CORS_ORIGINS to your domains
   - Remove wildcard (*) in production

3. **Database Security**:
   - Use SSL connections
   - Regular security updates
   - Backup encryption

4. **API Security**:
   - Rate limiting
   - Input validation
   - Authentication required

## 💰 Cost Estimation

### Free Tier Limits

- **Web Services**: 750 hours/month
- **PostgreSQL**: 1GB storage, 1GB RAM
- **Static Sites**: Unlimited

### Paid Plans

- **Starter**: $7/month per service
- **Standard**: $25/month per service
- **Pro**: $85/month per service

## 🚀 Going Live

1. **Test Everything**:
   - Test all API endpoints
   - Verify frontend functionality
   - Check database operations

2. **Update DNS**:
   - Point your domain to Render
   - Update environment variables

3. **Monitor**:
   - Watch for errors
   - Monitor performance
   - Set up alerts

## 📞 Support

- **Render Documentation**: [render.com/docs](https://render.com/docs)
- **Community Forum**: [community.render.com](https://community.render.com)
- **Status Page**: [status.render.com](https://status.render.com)

---

## 🎯 Quick Start Checklist

- [ ] Push code to GitHub
- [ ] Create Render account
- [ ] Deploy using Blueprint or manual setup
- [ ] Configure environment variables
- [ ] Test all services
- [ ] Set up custom domain (optional)
- [ ] Configure monitoring
- [ ] Go live!

Your Railway Fittings Management System should now be running on Render! 🚂
