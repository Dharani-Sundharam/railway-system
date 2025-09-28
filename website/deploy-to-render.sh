#!/bin/bash

# Railway System - Render Deployment Script (SQLite Version)
# This script helps prepare your application for Render deployment

set -e

echo "🚂 Railway System - Render Deployment Preparation (SQLite)"
echo "========================================================="
echo ""

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

print_status() {
    echo -e "${GREEN}[INFO]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

print_header() {
    echo -e "${BLUE}$1${NC}"
}

# Check if we're in the right directory
if [ ! -f "render.yaml" ]; then
    print_error "Please run this script from the website/ directory"
    exit 1
fi

print_header "🔍 Checking deployment files..."

# Check required files
required_files=(
    "render.yaml"
    "backend/requirements.txt"
    "frontend/package.json"
)

for file in "${required_files[@]}"; do
    if [ -f "$file" ]; then
        print_status "✅ $file exists"
    else
        print_error "❌ $file is missing"
        exit 1
    fi
done

print_header "🔧 Preparing for deployment..."

print_status "Configuration Summary:"
echo "  - Backend: Python FastAPI with SQLite"
echo "  - Frontend: React static site"
echo "  - Database: SQLite (no external database needed)"
echo "  - Services: 2 services (backend + frontend)"
echo ""

print_header "📋 Deployment Checklist:"
echo ""
echo "1. Push your code to GitHub:"
echo "   git add ."
echo "   git commit -m 'Deploy to Render with SQLite'"
echo "   git push origin main"
echo ""
echo "2. Go to https://render.com and:"
echo "   - Sign up/Login to your account"
echo "   - Click 'New +' → 'Blueprint'"
echo "   - Connect your GitHub repository"
echo "   - Select your repository"
echo "   - Click 'Apply' to deploy both services"
echo ""
echo "3. Environment Variables (auto-configured):"
echo "   Backend Service:"
echo "   - DATABASE_URL: sqlite:///./railway_fittings.db"
echo "   - SECRET_KEY: (auto-generated)"
echo "   - CORS_ORIGINS: https://railway-frontend.onrender.com"
echo "   - ALLOWED_HOSTS: railway-backend.onrender.com"
echo ""
echo "   Frontend Service:"
echo "   - REACT_APP_API_URL: https://railway-backend.onrender.com"
echo "   - REACT_APP_APP_NAME: Railway Fittings Management System"
echo ""
echo "4. After deployment:"
echo "   - Test your backend API at: https://railway-backend.onrender.com"
echo "   - Test your frontend at: https://railway-frontend.onrender.com"
echo "   - Check API docs at: https://railway-backend.onrender.com/docs"
echo ""

print_header "🎯 Quick Commands:"
echo ""
echo "# Push to GitHub:"
echo "git add . && git commit -m 'Deploy to Render' && git push origin main"
echo ""
echo "# Check deployment status:"
echo "# Visit https://dashboard.render.com"
echo ""

print_header "💡 Benefits of SQLite Deployment:"
echo "  ✅ No external database setup required"
echo "  ✅ Faster deployment"
echo "  ✅ Lower cost (no database service)"
echo "  ✅ Simpler configuration"
echo "  ✅ Perfect for development and small to medium applications"
echo ""

print_success "Deployment preparation complete!"
print_status "Your application will use SQLite database - no external database needed!"
