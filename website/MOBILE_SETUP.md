# 📱 Mobile App Setup Guide

Complete guide for setting up and running the Railway Track Fittings Mobile App.

## 🚀 Quick Start (3 Steps)

### Step 1: Start the Backend
```bash
cd SIH_RQR-main
./launch.sh
```

### Step 2: Setup Mobile App
```bash
cd mobile
./setup-mobile.sh
```

### Step 3: Install Expo Go
- **Android**: [Download from Play Store](https://play.google.com/store/apps/details?id=host.exp.exponent)
- **iOS**: [Download from App Store](https://apps.apple.com/app/expo-go/id982107779)

## 📋 Detailed Setup Instructions

### Prerequisites Check
- ✅ Node.js 18+ installed
- ✅ Backend running on http://localhost:8000
- ✅ Mobile device with Expo Go app

### Option A: Physical Device (Recommended for QR Scanning)

1. **Start Backend**:
   ```bash
   cd SIH_RQR-main
   ./launch.sh
   ```

2. **Setup Mobile App**:
   ```bash
   cd mobile
   ./setup-mobile.sh
   ```

3. **Configure Network** (if needed):
   ```bash
   ./get-ip.sh
   ```

4. **Start Development Server**:
   ```bash
   npm start
   ```

5. **Scan QR Code**:
   - Open Expo Go app on your phone
   - Scan the QR code displayed in terminal
   - Grant camera and location permissions

### Option B: Android Emulator

1. **Install Android Studio**:
   - Download from [developer.android.com](https://developer.android.com/studio)
   - Install with default settings

2. **Create Virtual Device**:
   - Open Android Studio
   - Tools → AVD Manager
   - Create Virtual Device
   - Choose Pixel 4 or similar
   - Select Android 11+ (API 30+)

3. **Start Emulator**:
   ```bash
   cd mobile
   npm run android
   ```

### Option C: iOS Simulator (macOS only)

1. **Install Xcode**:
   - Download from Mac App Store
   - Install Xcode Command Line Tools

2. **Start Simulator**:
   ```bash
   cd mobile
   npm run ios
   ```

## 🔧 Configuration

### API Configuration
The mobile app connects to the backend at `http://localhost:8000` by default.

**For Physical Device Testing:**
- Run `./get-ip.sh` to get your local IP
- Update `src/services/api.ts` with your IP address
- Ensure phone and computer are on same WiFi network

### Permissions
The app requires:
- **Camera**: For QR code scanning
- **Location**: For recording scan locations

## 🔐 Login Credentials

| Role | Username | Password |
|------|----------|----------|
| **Admin** | `admin` | `admin123` |
| **Inspector** | `inspector1` | `inspector123` |
| **Depot Manager** | `depot_manager` | `depot123` |

## 📱 App Features

### 🏠 Home Screen
- Component statistics dashboard
- Quick access to scanning
- Recent activity feed

### 📷 QR Scanner
- Camera-based QR scanning
- Automatic component lookup
- GPS location recording
- Offline capability

### 🔍 Component Details
- Detailed component information
- Inspection history
- QR code display
- Status updates

### 📋 Inspections
- Create new inspections
- View inspection history
- Photo attachments
- Status tracking

### 👤 Profile
- User information
- Settings
- Logout

## 🛠️ Troubleshooting

### Common Issues

#### "Cannot connect to backend"
- Ensure backend is running: `cd .. && ./launch.sh`
- Check backend health: http://localhost:8000/health
- For physical device: Update API URL with your IP

#### "Camera permission denied"
- Grant camera permission in device settings
- For emulator: Enable camera in AVD settings

#### "Expo Go not working"
- Update Expo Go to latest version
- Clear Expo Go cache
- Restart development server

#### "Metro bundler issues"
```bash
npx expo install --fix
npm start --clear
```

### Development Tips

1. **Hot Reload**: Changes appear automatically
2. **Debug Menu**: Shake device or press `Cmd+D` (iOS) / `Cmd+M` (Android)
3. **Logs**: Check terminal for error messages
4. **Network**: Ensure device and computer on same network

## 📦 Building for Production

### Android APK
```bash
expo build:android
```

### iOS IPA
```bash
expo build:ios
```

## 🔗 Useful Commands

| Command | Description |
|---------|-------------|
| `npm start` | Start development server |
| `npm run android` | Run on Android |
| `npm run ios` | Run on iOS |
| `npm run web` | Run in browser |
| `./setup-mobile.sh` | Automated setup |
| `./get-ip.sh` | Get local IP for device testing |

## 🎯 Testing Workflow

1. **Start Backend**: `./launch.sh`
2. **Setup Mobile**: `./setup-mobile.sh`
3. **Install Expo Go** on phone
4. **Start App**: `npm start`
5. **Scan QR Code** with Expo Go
6. **Login** with demo credentials
7. **Test QR Scanning** functionality

## 🆘 Support

If you encounter issues:

1. **Check Prerequisites**: Node.js 18+, backend running
2. **Review Logs**: Check terminal output
3. **Network Issues**: Run `./get-ip.sh` for device testing
4. **Permission Issues**: Grant camera/location permissions
5. **Restart Services**: Stop and restart backend/mobile app

## 🎉 Success Indicators

You'll know the setup is working when:
- ✅ Backend shows "Application startup complete"
- ✅ Mobile app shows QR code in terminal
- ✅ Expo Go app loads the Railway Fittings app
- ✅ Login screen appears
- ✅ You can successfully login with demo credentials

---

**Ready to scan railway components! 🚂📱**
