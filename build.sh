#!/bin/bash

# Railway System - Build Script
# Builds the frontend for production deployment

set -e

echo "🚂 Building Railway System..."

# Check if we're in the right directory
if [ ! -f "main.py" ]; then
    echo "❌ Error: main.py not found. Please run this script from the project root."
    exit 1
fi

# Build frontend
echo "📦 Building frontend..."
if [ -d "frontend" ]; then
    cd frontend
    
    # Install dependencies if node_modules doesn't exist
    if [ ! -d "node_modules" ]; then
        echo "📥 Installing frontend dependencies..."
        npm install
    fi
    
    # Build the frontend
    echo "🔨 Building React app..."
    npm run build
    
    cd ..
    echo "✅ Frontend built successfully!"
else
    echo "❌ Error: frontend directory not found"
    exit 1
fi

# Create static directories for backend
echo "📁 Creating backend static directories..."
mkdir -p backend/static/qr_codes
mkdir -p backend/static/uploads

echo "✅ Build complete!"
echo ""
echo "📋 Next steps:"
echo "   1. Run: python main.py"
echo "   2. Visit: http://localhost:8000"
echo "   3. Login with: admin / admin123"
echo ""
echo "🌐 Your Railway System is ready!"
