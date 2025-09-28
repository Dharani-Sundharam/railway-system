#!/bin/bash

# Railway Track Fittings Management System - Unified Launch & Stop Script
# Smart India Hackathon 2025

set -e  # Exit on any error

echo "🚂 Railway Track Fittings Management System"
echo "=========================================="
echo ""

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
PURPLE='\033[0;35m'
NC='\033[0m' # No Color

# Configuration
BACKEND_PORT=8000
FRONTEND_PORT=3000
BACKEND_URL="http://localhost:$BACKEND_PORT"
FRONTEND_URL="http://localhost:$FRONTEND_PORT"

# Function to print colored output
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

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

# Check prerequisites
check_prerequisites() {
    print_header "🔍 Checking Prerequisites..."
    
    # Check Python
    if ! command -v python3 &> /dev/null; then
        print_error "Python 3 is not installed. Please install Python 3.11+ first."
        print_status "Visit: https://www.python.org/downloads/"
        exit 1
    fi
    print_status "✅ Python found: $(python3 --version)"

    # Check Node.js
    if ! command -v node &> /dev/null; then
        print_error "Node.js is not installed. Please install Node.js 18+ first."
        print_status "Visit: https://nodejs.org/"
    exit 1
fi
    print_status "✅ Node.js found: $(node --version)"

    # Check npm
    if ! command -v npm &> /dev/null; then
        print_error "npm is not installed. Please install npm first."
    exit 1
fi
    print_status "✅ npm found: $(npm --version)"

    # Check if we're in the right directory
    if [ ! -d "backend" ] || [ ! -d "frontend" ]; then
        print_error "Please run this script from the SIH_RQR-main directory"
    exit 1
fi
    print_success "All prerequisites met!"
}

# Clean up existing processes
cleanup_ports() {
    print_header "🧹 Cleaning up existing processes..."
    
    for port in $BACKEND_PORT $FRONTEND_PORT; do
        if lsof -i :$port >/dev/null 2>&1; then
            print_warning "Port $port is in use. Attempting to free it..."
            lsof -ti :$port | xargs -r kill -9 2>/dev/null || true
            sleep 2
        fi
    done
    print_success "Port cleanup completed!"
}

# Setup backend
setup_backend() {
    print_header "🔧 Setting up Backend..."
    
    cd backend
    
    # Create virtual environment if it doesn't exist
    if [ ! -d "venv" ]; then
        print_status "Creating Python virtual environment..."
        python3 -m venv venv
    fi
    
    # Activate virtual environment
    source venv/bin/activate
    
    # Install dependencies
    print_status "Installing Python dependencies..."
    pip install -r requirements.txt
    
    # Start backend in background
    print_status "Starting FastAPI backend on port $BACKEND_PORT..."
    uvicorn app.main:app --host 0.0.0.0 --port $BACKEND_PORT &
    BACKEND_PID=$!
    
    # Wait for backend to start
    sleep 5
    
    # Go back to root directory
    cd ..
    
    print_success "Backend setup completed!"
}

# Setup frontend
setup_frontend() {
    print_header "🎨 Setting up Frontend..."
    
    cd frontend
    
    # Install dependencies if node_modules doesn't exist
    if [ ! -d "node_modules" ]; then
        print_status "Installing Node.js dependencies..."
        npm install
    fi
    
    # Start frontend in background
    print_status "Starting React frontend on port $FRONTEND_PORT..."
    npm start &
    FRONTEND_PID=$!
    
    # Go back to root directory
    cd ..
    
    print_success "Frontend setup completed!"
}

# Wait for services to be ready
wait_for_services() {
    print_header "⏳ Waiting for services to be ready..."
    
    # Wait for backend
    print_status "Waiting for backend to be ready..."
    for i in {1..30}; do
        if curl -s "$BACKEND_URL/docs" >/dev/null 2>&1; then
            print_success "Backend is ready!"
            break
        fi
        if [ $i -eq 30 ]; then
            print_warning "Backend may not be fully ready yet"
        fi
        sleep 1
    done
    
    # Wait for frontend
    print_status "Waiting for frontend to be ready..."
    for i in {1..30}; do
        if curl -s "$FRONTEND_URL" >/dev/null 2>&1; then
            print_success "Frontend is ready!"
            break
        fi
        if [ $i -eq 30 ]; then
            print_warning "Frontend may not be fully ready yet"
        fi
        sleep 1
    done
}

# Display system information
display_info() {
    print_header "✅ System Started Successfully!"
echo ""
    echo "🌐 Access Points:"
    echo "   Web Dashboard: $FRONTEND_URL"
    echo "   API Server:    $BACKEND_URL"
    echo "   API Docs:      $BACKEND_URL/docs"
    echo ""
    echo "📊 Database: SQLite (railway_fittings.db)"
    echo ""
    echo "🔑 Demo Credentials:"
    echo "   Admin:         admin / admin123"
    echo "   Inspector:     inspector1 / inspector123"
    echo "   Depot Manager: depot_manager / depot123"
    echo ""
    echo "🛑 To stop the system:"
    echo "   Press Ctrl+C"
    echo ""
}

# Cleanup function
cleanup() {
    print_status "Stopping system..."
    kill $BACKEND_PID 2>/dev/null || true
    kill $FRONTEND_PID 2>/dev/null || true
    print_success "System stopped!"
    exit 0
}

# Main execution
main() {
    check_prerequisites
    cleanup_ports
    setup_backend
    setup_frontend
    wait_for_services
    display_info
    
    # Set trap to cleanup on script exit
    trap cleanup SIGINT SIGTERM
    
    print_status "System is running. Press Ctrl+C to stop."
    echo ""
    
    # Wait for user to stop
    wait
}

# Run main function
main