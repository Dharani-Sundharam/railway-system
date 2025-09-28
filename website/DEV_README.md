# Development Setup for SIH RQR

This document explains how to run the SIH RQR application in development mode with hot reloading.

## Quick Start

### Single Command Development
```bash
./dev-start.sh
```

This single script will:
- Set up Python virtual environment (if needed)
- Install all dependencies (if needed)
- Start backend API with hot reloading
- Start frontend with hot reloading
- Display all service URLs

### Stop Development Environment
```bash
./dev-stop.sh
```

## What's Running

When you run `./dev-start.sh`, you'll have:

- **Frontend**: http://localhost:3000 (React with hot reloading)
- **Backend API**: http://localhost:8000 (FastAPI with auto-reload)
- **API Documentation**: http://localhost:8000/docs
- **Database**: SQLite file (railway_fittings.db)

## Hot Reloading Features

### Frontend Changes
- Edit any `.tsx`, `.ts`, `.css` file in `frontend/src/`
- Changes appear instantly in browser (no rebuild needed)
- Logo changes will be visible immediately

### Backend Changes
- Edit any `.py` file in `backend/app/`
- API server automatically restarts
- Changes reflected in seconds

## Development vs Production

### Development Mode (Recommended for coding)
```bash
./dev-start.sh
```
- Hot reloading enabled
- Fast iteration
- Only databases in Docker
- Frontend and backend run locally

### Production Mode (For deployment)
```bash
docker-compose up --build -d
```
- Full containerized setup
- Optimized builds
- All services in Docker
- No hot reloading

## Troubleshooting

### Port Conflicts
If you get port conflicts, stop all services:
```bash
./dev-stop.sh
```

### Database Issues
Reset the database:
```bash
docker-compose down
docker-compose up db redis -d
```

### Dependencies Issues
The script automatically installs dependencies, but if you need to reinstall:
```bash
# Backend
cd backend
rm -rf venv
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt

# Frontend
cd frontend
rm -rf node_modules
npm install
```

## File Structure
```
SIH_RQR-main/
├── dev-start.sh          # Single command to start everything
├── dev-stop.sh           # Stop all development services
├── backend/              # FastAPI backend
│   ├── venv/            # Python virtual environment
│   ├── railway_fittings.db  # SQLite database
│   └── app/             # Backend source code
├── frontend/             # React frontend
│   ├── node_modules/    # Node.js dependencies
│   ├── public/          # Static files (including logos)
│   └── src/             # Frontend source code
└── DEV_README.md        # This file
```

## Logo Development

The logo files are located in `frontend/public/`:
- `main_logo_32.png` - 32x32px for sidebar
- `main_logo_64.png` - 64x64px for login page
- `main_logo.png` - Original 500x500px

To update logos:
1. Replace the files in `frontend/public/`
2. Changes appear immediately (no restart needed)

## Tips

- Use `Ctrl+C` to stop the development script
- The script handles cleanup automatically
- All logs are displayed in the terminal
- Database data persists between restarts
- Frontend and backend run in parallel for maximum speed
