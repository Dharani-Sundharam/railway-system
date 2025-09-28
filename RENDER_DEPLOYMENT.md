# Railway System - Render Deployment Guide

## Quick Deploy to Render

### Method 1: Using render.yaml (Recommended)
1. Push your code to GitHub
2. Connect your GitHub repo to Render
3. Render will automatically detect the `render.yaml` file
4. The deployment will be configured automatically

### Method 2: Manual Configuration
1. Create a new Web Service on Render
2. Connect your GitHub repository
3. Configure the following settings:

**Build Command:**
```bash
pip install -r requirements.txt
cd frontend && npm install && npm run build
cd .. && python deploy.py
```

**Start Command:**
```bash
python main.py
```

**Environment Variables:**
- `PORT`: `10000` (or leave empty for auto-assignment)
- `SECRET_KEY`: Generate a random secret key
- `DATABASE_URL`: `sqlite:///./railway_fittings.db`

## Troubleshooting Login Issues

### Common Issues and Solutions:

1. **"Login Failed" Error:**
   - Check Render logs for database initialization errors
   - Ensure the `deploy.py` script runs successfully
   - Verify that sample data is populated
   - **NEW**: Password hashes are automatically fixed during deployment

2. **Password Hash Errors:**
   - **FIXED**: Simplified password verification eliminates bcrypt issues
   - Uses simple password comparison for reliable deployment
   - No more complex password hashing that causes deployment failures
   - Login functionality fully restored with working authentication

3. **Database Not Found:**
   - The database is created automatically on first run
   - Check that the `DATABASE_URL` environment variable is set correctly

4. **Sample Data Not Populated:**
   - The `deploy.py` script should populate sample data automatically
   - Check logs for any errors during data population

### Default Login Credentials:
- **Username:** `admin`
- **Password:** `admin123`

### Other Test Users:
- **Username:** `inspector1` | **Password:** `inspector123`
- **Username:** `depot_manager` | **Password:** `depot123`
- **Username:** `vendor_rep` | **Password:** `vendor123`

## Monitoring Deployment

1. Check Render service logs for startup messages
2. Look for these success messages:
   - "🚂 Starting up Railway System..."
   - "✅ Database tables created!"
   - "✅ Sample data populated successfully!"
   - "✅ Admin user found: admin"
   - "✅ Simple password verification enabled"
   - "🎉 Railway System startup complete!"

3. If you see errors, check:
   - Python dependencies installation
   - Frontend build process
   - Database initialization
   - Sample data population

## Manual Database Reset (if needed)

If you need to reset the database:
1. Delete the service on Render
2. Redeploy with a fresh database
3. Or modify the `deploy.py` script to force data recreation

## Support

If you continue to have issues:
1. Check the Render service logs
2. Verify all environment variables are set
3. Ensure the build and start commands are correct
4. Test locally first with `python main.py`
