# Railway QR Scanner - Android App

A native Android application for scanning QR codes of railway track fittings and displaying detailed component information.

## Features

- **QR Code Scanning**: Real-time camera-based QR code scanning
- **Component Details**: Comprehensive component information display
- **Offline Database**: Local SQLite database with hardcoded sample data
- **Material Design**: Modern UI following Material Design 3 guidelines
- **Railway Theme**: Customized colors and styling for railway industry

## Sample Data

The app includes a comprehensive dummy database with:

- **100 Sample Components** with realistic serial IDs
- **5 Railway Vendors** with contact information
- **5 Railway Locations** across different zones
- **200 Sample Inspections** with various statuses
- **Component Types**: Elastic Rail Clips, Liners, Rail Pads, Sleepers
- **Status Tracking**: From manufacturing to service lifecycle

## Sample QR Codes

The app can scan QR codes with these sample serial IDs:

- `ELA001000001` - Elastic Rail Clip from Bharat Rail Components
- `LIN002000002` - Liner from Indian Steel Fittings
- `PAD003000003` - Rail Pad from Metro Rail Solutions
- `SLE004000004` - Sleeper from TrackTech Industries
- And 96 more sample components...

## Technical Stack

- **Language**: Kotlin
- **Architecture**: MVVM with Repository pattern
- **Database**: Room (SQLite)
- **UI**: Material Design 3
- **QR Scanning**: ZXing library
- **Async Operations**: Kotlin Coroutines
- **Image Loading**: Glide

## Project Structure

```
app/
├── src/main/java/com/railway/qrscanner/
│   ├── data/
│   │   ├── model/          # Data models (Component, Vendor, etc.)
│   │   ├── database/       # Room database setup
│   │   ├── dao/           # Data Access Objects
│   │   └── repository/    # Dummy data repository
│   ├── ui/
│   │   ├── scanner/       # QR Scanner activity
│   │   └── details/       # Component details activity
│   └── MainActivity.kt    # Main activity
└── src/main/res/
    ├── layout/            # XML layouts
    ├── drawable/          # Icons and graphics
    ├── values/            # Colors, strings, themes
    └── ...
```

## Installation & Setup

1. **Prerequisites**:
   - Android Studio Arctic Fox or later
   - Android SDK 24+ (Android 7.0)
   - Kotlin 1.9.10+

2. **Build the Project**:
   ```bash
   cd android-app
   ./gradlew build
   ```

3. **Install on Device**:
   ```bash
   ./gradlew installDebug
   ```

## Usage

1. **Launch the App**: Open "Railway QR Scanner" from your device
2. **Scan QR Code**: Tap "Scan QR Code" and point camera at a QR code
3. **View Details**: Component information will be displayed automatically
4. **Browse Components**: Use "View Components" to see sample data

## Permissions

The app requires these permissions:
- **Camera**: For QR code scanning
- **Location**: For GPS coordinates (optional)
- **Internet**: For future API integration

## Database Schema

### Components Table
- Serial ID, Type, Status, Dates, Vendor, Location
- Material specifications, Batch/Lot numbers
- Warranty information

### Vendors Table
- Company information, Contact details
- Quality ratings, Certification status

### Locations Table
- Railway zones, Divisions, Sections
- Station codes, Track information
- GPS coordinates

### Inspections Table
- Inspection history, Status, Findings
- Recommendations, Next due dates
- Measurements and photos

## Customization

### Adding New Sample Data
Edit `DummyDataRepository.kt` to add more components, vendors, or locations.

### Modifying UI
Update layout files in `res/layout/` and colors in `res/values/colors.xml`.

### Changing QR Format
Modify the serial ID generation logic in `DummyDataRepository.kt`.

## Future Enhancements

- [ ] API integration with backend
- [ ] Offline sync capabilities
- [ ] New inspection creation
- [ ] Location mapping
- [ ] Analytics dashboard
- [ ] Photo capture for inspections
- [ ] Export functionality

## Troubleshooting

### Common Issues

1. **Camera Permission Denied**:
   - Go to Settings > Apps > Railway QR Scanner > Permissions
   - Enable Camera permission

2. **QR Code Not Recognized**:
   - Ensure good lighting
   - Hold device steady
   - Try different angles

3. **Component Not Found**:
   - Use sample serial IDs: ELA001000001, LIN002000002, etc.
   - Check if database is initialized

### Debug Mode
Enable debug logging by adding this to your `build.gradle`:
```gradle
android {
    buildTypes {
        debug {
            debuggable true
        }
    }
}
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

## License

This project is part of the Smart India Hackathon 2025 Railway Track Fittings Management System.

---

**Built with ❤️ for Indian Railways**
