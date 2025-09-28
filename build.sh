#!/bin/bash

# Railway System - Unified Build Script
# Builds both backend and frontend for deployment

set -e

echo "🚂 Building Railway System..."

# Build frontend
echo "📦 Building frontend..."
cd website/frontend
npm install
npm run build
cd ../..

# Create static directories
echo "📁 Creating static directories..."
mkdir -p website/backend/static/qr_codes
mkdir -p website/backend/static/uploads

echo "✅ Build complete!"
echo "Frontend built in: website/frontend/build"
echo "Backend ready in: website/backend"
