package com.railway.qrscanner.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0014\u001a\u00020\fH\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0012\u001a\u00020\fH\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0017\u001a\u00020\u000fH\'J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u001a\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001e"}, d2 = {"Lcom/railway/qrscanner/data/dao/ComponentDao;", "", "deleteComponent", "", "component", "Lcom/railway/qrscanner/data/model/Component;", "(Lcom/railway/qrscanner/data/model/Component;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllComponents", "Lkotlinx/coroutines/flow/Flow;", "", "getComponentBySerialId", "serialId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentCountByType", "type", "getComponentsByStatus", "status", "getComponentsByType", "getComponentsByVendor", "vendorId", "getFirstComponent", "insertComponent", "insertComponents", "components", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComponent", "app_debug"})
@androidx.room.Dao()
public abstract interface ComponentDao {
    
    @androidx.room.Query(value = "SELECT * FROM components")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Component>> getAllComponents();
    
    @androidx.room.Query(value = "SELECT * FROM components WHERE serialId = :serialId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComponentBySerialId(@org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Component> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM components WHERE componentType = :type")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Component>> getComponentsByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @androidx.room.Query(value = "SELECT * FROM components WHERE currentStatus = :status")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Component>> getComponentsByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT * FROM components WHERE vendorId = :vendorId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Component>> getComponentsByVendor(int vendorId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertComponent(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Component component, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertComponents(@org.jetbrains.annotations.NotNull()
    java.util.List<com.railway.qrscanner.data.model.Component> components, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateComponent(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Component component, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteComponent(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Component component, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM components")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComponentCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM components WHERE componentType = :type")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComponentCountByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM components LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFirstComponent(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Component> $completion);
}