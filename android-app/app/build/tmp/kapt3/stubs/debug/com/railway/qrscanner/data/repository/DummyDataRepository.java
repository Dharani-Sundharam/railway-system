package com.railway.qrscanner.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J \u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0002J \u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u000e\u0010\'\u001a\u00020(H\u0086@\u00a2\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/railway/qrscanner/data/repository/DummyDataRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/railway/qrscanner/data/database/AppDatabase;", "dateFormat", "Ljava/text/SimpleDateFormat;", "createDummyComponents", "", "Lcom/railway/qrscanner/data/model/Component;", "vendors", "Lcom/railway/qrscanner/data/model/Vendor;", "locations", "Lcom/railway/qrscanner/data/model/Location;", "createDummyInspections", "Lcom/railway/qrscanner/data/model/Inspection;", "components", "createDummyLocations", "createDummyVendors", "generateFindings", "", "status", "Lcom/railway/qrscanner/data/model/InspectionStatus;", "generateMeasurements", "generateSerialId", "componentType", "Lcom/railway/qrscanner/data/model/ComponentType;", "vendorCode", "index", "", "getRandomDate", "daysFromNow", "daysToNow", "getRandomDateAfter", "baseDate", "minDays", "maxDays", "populateDummyData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DummyDataRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.railway.qrscanner.data.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    
    public DummyDataRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object populateDummyData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<com.railway.qrscanner.data.model.Vendor> createDummyVendors() {
        return null;
    }
    
    private final java.util.List<com.railway.qrscanner.data.model.Location> createDummyLocations() {
        return null;
    }
    
    private final java.util.List<com.railway.qrscanner.data.model.Component> createDummyComponents(java.util.List<com.railway.qrscanner.data.model.Vendor> vendors, java.util.List<com.railway.qrscanner.data.model.Location> locations) {
        return null;
    }
    
    private final java.util.List<com.railway.qrscanner.data.model.Inspection> createDummyInspections(java.util.List<com.railway.qrscanner.data.model.Component> components) {
        return null;
    }
    
    private final java.lang.String generateSerialId(com.railway.qrscanner.data.model.ComponentType componentType, java.lang.String vendorCode, int index) {
        return null;
    }
    
    private final java.lang.String getRandomDate(int daysFromNow, int daysToNow) {
        return null;
    }
    
    private final java.lang.String getRandomDateAfter(java.lang.String baseDate, int minDays, int maxDays) {
        return null;
    }
    
    private final java.lang.String generateFindings(com.railway.qrscanner.data.model.InspectionStatus status) {
        return null;
    }
    
    private final java.lang.String generateMeasurements() {
        return null;
    }
}