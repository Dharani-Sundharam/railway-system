package com.railway.qrscanner.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\fH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\fH\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/railway/qrscanner/data/dao/InspectionDao;", "", "deleteInspection", "", "inspection", "Lcom/railway/qrscanner/data/model/Inspection;", "(Lcom/railway/qrscanner/data/model/Inspection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllInspections", "Lkotlinx/coroutines/flow/Flow;", "", "getInspectionById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInspectionsByComponent", "componentId", "getInspectionsByInspector", "inspectorId", "getInspectionsByStatus", "status", "", "insertInspection", "insertInspections", "inspections", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInspection", "app_debug"})
@androidx.room.Dao()
public abstract interface InspectionDao {
    
    @androidx.room.Query(value = "SELECT * FROM inspections")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Inspection>> getAllInspections();
    
    @androidx.room.Query(value = "SELECT * FROM inspections WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getInspectionById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.railway.qrscanner.data.model.Inspection> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM inspections WHERE componentId = :componentId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Inspection>> getInspectionsByComponent(int componentId);
    
    @androidx.room.Query(value = "SELECT * FROM inspections WHERE inspectorId = :inspectorId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Inspection>> getInspectionsByInspector(int inspectorId);
    
    @androidx.room.Query(value = "SELECT * FROM inspections WHERE status = :status")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.railway.qrscanner.data.model.Inspection>> getInspectionsByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertInspection(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Inspection inspection, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertInspections(@org.jetbrains.annotations.NotNull()
    java.util.List<com.railway.qrscanner.data.model.Inspection> inspections, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateInspection(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Inspection inspection, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteInspection(@org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.Inspection inspection, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}