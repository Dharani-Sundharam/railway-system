# Android App Backend Connection Setup Guide

## Problem
The Android app was only using local dummy data and couldn't access the real component data from the backend server.

## Solution Implemented
Added network connectivity to fetch component data from the backend server when local data is not available.

## Setup Instructions

### 1. Start the Backend Server
```bash
cd SIH_RQR-main/backend
python -m uvicorn app.main:app --host 0.0.0.0 --port 8000 --reload
```

### 2. Configure Network Access

#### For Android Emulator:
The app is configured to use `http://10.0.2.2:8000/` which maps to your computer's localhost.

#### For Physical Device:
1. Find your computer's IP address:
   ```bash
   # Linux/Mac
   ip addr show
   # or
   ifconfig
   
   # Windows
   ipconfig
   ```

2. Update the BASE_URL in `ApiClient.kt`:
   ```kotlin
   private const val BASE_URL = "http://YOUR_IP_ADDRESS:8000/"
   ```

### 3. Build and Run the App
```bash
cd android-app
./gradlew assembleDebug
```

## How It Works

1. **Local First**: The app first checks the local Room database for component data
2. **Server Fallback**: If not found locally, it fetches from the backend API
3. **Auto-Sync**: On app startup, it syncs all components from the server
4. **Caching**: Fetched data is saved locally for offline use

## Key Files Added/Modified

- `data/api/ApiModels.kt` - API response models
- `data/api/ApiService.kt` - Retrofit service interface
- `data/api/ApiClient.kt` - HTTP client configuration
- `data/repository/ComponentRepository.kt` - Repository for data access
- `ui/scanner/ScannerActivity.kt` - Updated to use repository
- `MainActivity.kt` - Added server sync on startup
- `build.gradle` - Added Retrofit and OkHttp dependencies

## Testing

1. Start the backend server
2. Run the Android app
3. Scan a QR code that exists in the backend database
4. The app should fetch and display the component details

## Troubleshooting

- **Connection refused**: Make sure the backend server is running on port 8000
- **Component not found**: Check if the component exists in the backend database
- **Network timeout**: Verify your IP address and network connectivity
- **CORS errors**: The backend is configured to allow all origins for development

## Backend Endpoints Used

- `GET /components/` - Get all components
- `GET /components/{serial_id}` - Get component by serial ID
- `GET /vendors/` - Get all vendors
- `GET /locations/` - Get all locations
