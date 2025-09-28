package com.railway.qrscanner.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u000e\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/railway/qrscanner/data/repository/ComponentRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiService", "Lcom/railway/qrscanner/data/api/ApiService;", "database", "Lcom/railway/qrscanner/data/database/AppDatabase;", "dateFormat", "Ljava/text/SimpleDateFormat;", "convertApiComponentToLocal", "Lcom/railway/qrscanner/data/model/Component;", "apiComponent", "Lcom/railway/qrscanner/data/api/ApiComponent;", "convertApiLocationToLocal", "Lcom/railway/qrscanner/data/model/Location;", "apiLocation", "Lcom/railway/qrscanner/data/api/ApiLocation;", "convertApiVendorToLocal", "Lcom/railway/qrscanner/data/model/Vendor;", "apiVendor", "Lcom/railway/qrscanner/data/api/ApiVendor;", "getComponentBySerialId", "serialId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFirstComponent", "syncComponentsFromServer", "", "app_debug"})
public final class ComponentRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.railway.qrscanner.data.database.AppDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.railway.qrscanner.data.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    
    public ComponentRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getComponentBySerialId(@org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Component> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncComponentsFromServer(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getComponentCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFirstComponent(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Component> $completion) {
        return null;
    }
    
    private final com.railway.qrscanner.data.model.Component convertApiComponentToLocal(com.railway.qrscanner.data.api.ApiComponent apiComponent) {
        return null;
    }
    
    private final com.railway.qrscanner.data.model.Vendor convertApiVendorToLocal(com.railway.qrscanner.data.api.ApiVendor apiVendor) {
        return null;
    }
    
    private final com.railway.qrscanner.data.model.Location convertApiLocationToLocal(com.railway.qrscanner.data.api.ApiLocation apiLocation) {
        return null;
    }
}