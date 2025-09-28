#!/bin/bash

# Railway System - Unified Build Script
# Builds both backend and frontend for deployment

set -e

echo "🚂 Building Railway System..."

# Build frontend
echo "📦 Building frontend..."
cd frontend
npm install
npm run build
cd ..

# Create static directories
echo "📁 Creating static directories..."
mkdir -p backend/static/qr_codes
mkdir -p backend/static/uploads

echo "✅ Build complete!"
echo "Frontend built in: frontend/build"
echo "Backend ready in: backend"
