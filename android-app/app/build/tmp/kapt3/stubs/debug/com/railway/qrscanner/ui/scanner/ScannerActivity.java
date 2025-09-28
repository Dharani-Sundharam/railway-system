package com.railway.qrscanner.ui.scanner;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0014J\b\u0010\u0017\u001a\u00020\rH\u0014J-\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\rH\u0014J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010\'\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/railway/qrscanner/ui/scanner/ScannerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/railway/qrscanner/databinding/ActivityScannerBinding;", "componentRepository", "Lcom/railway/qrscanner/data/repository/ComponentRepository;", "database", "Lcom/railway/qrscanner/data/database/AppDatabase;", "isScanning", "", "isTorchOn", "checkCameraPermission", "", "extractComponentId", "", "qrResult", "handleScanResult", "scanResult", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openWebInterface", "url", "setupBarcodeScanner", "setupUI", "startScanning", "stopScanning", "toggleFlash", "Companion", "app_debug"})
public final class ScannerActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.railway.qrscanner.databinding.ActivityScannerBinding binding;
    private com.railway.qrscanner.data.database.AppDatabase database;
    private com.railway.qrscanner.data.repository.ComponentRepository componentRepository;
    private boolean isScanning = false;
    private boolean isTorchOn = false;
    private static final int CAMERA_PERMISSION_REQUEST = 1001;
    @org.jetbrains.annotations.NotNull()
    public static final com.railway.qrscanner.ui.scanner.ScannerActivity.Companion Companion = null;
    
    public ScannerActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupBarcodeScanner() {
    }
    
    private final void handleScanResult(java.lang.String scanResult) {
    }
    
    private final java.lang.String extractComponentId(java.lang.String qrResult) {
        return null;
    }
    
    private final void openWebInterface(java.lang.String url) {
    }
    
    private final void checkCameraPermission() {
    }
    
    private final void startScanning() {
    }
    
    private final void stopScanning() {
    }
    
    private final void toggleFlash() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/railway/qrscanner/ui/scanner/ScannerActivity$Companion;", "", "()V", "CAMERA_PERMISSION_REQUEST", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}