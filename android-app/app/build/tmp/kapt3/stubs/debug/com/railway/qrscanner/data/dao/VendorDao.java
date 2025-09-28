package com.railway.qrscanner.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/railway/qrscanner/data/dao/VendorDao;", "", "deleteVendor", "", "vendor", "Lcom/railway/qrscanner/data/model/Vendor;", "(Lcom/railway/qrscanner/data/model/Vendor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVendors", "Lkotlinx/coroutines/flow/Flow;", "", "getVendorByCode", "vendorCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVendorById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertVendor", "insertVendors", "vendors", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVendor", "app_debug"})
@androidx.room.Dao()
public abstract interface VendorDao {
    
    @androidx.room.Query(value = "SELECT * FROM vendors")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Vendor>> getAllVendors();
    
    @androidx.room.Query(value = "SELECT * FROM vendors WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVendorById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Vendor> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM vendors WHERE vendorCode = :vendorCode")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVendorByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String vendorCode, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Vendor> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVendor(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Vendor vendor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertVendors(@org.jetbrains.annotations.NotNull()
    java.util.List<com.railway.qrscanner.data.model.Vendor> vendors, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateVendor(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Vendor vendor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteVendor(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Vendor vendor, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}