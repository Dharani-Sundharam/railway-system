package com.railway.qrscanner.ui.details;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u001c\u0010\u001c\u001a\u00020\n2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/railway/qrscanner/ui/details/ComponentDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/railway/qrscanner/databinding/ActivityComponentDetailsBinding;", "componentSerialId", "", "database", "Lcom/railway/qrscanner/data/database/AppDatabase;", "displayComponentDetails", "", "component", "Lcom/railway/qrscanner/data/model/Component;", "(Lcom/railway/qrscanner/data/model/Component;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatComponentType", "type", "Lcom/railway/qrscanner/data/model/ComponentType;", "formatDate", "dateString", "formatInspectionStatus", "status", "Lcom/railway/qrscanner/data/model/InspectionStatus;", "formatStatus", "Lcom/railway/qrscanner/data/model/ComponentStatus;", "getInspectionStatusColor", "", "getStatusColor", "loadComponentDetails", "loadInspections", "inspections", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/railway/qrscanner/data/model/Inspection;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupUI", "app_debug"})
public final class ComponentDetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.railway.qrscanner.databinding.ActivityComponentDetailsBinding binding;
    private com.railway.qrscanner.data.database.AppDatabase database;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String componentSerialId;
    
    public ComponentDetailsActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void loadComponentDetails() {
    }
    
    private final java.lang.Object displayComponentDetails(com.railway.qrscanner.data.model.Component component, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void loadInspections(kotlinx.coroutines.flow.Flow<? extends java.util.List<com.railway.qrscanner.data.model.Inspection>> inspections) {
    }
    
    private final java.lang.String formatComponentType(com.railway.qrscanner.data.model.ComponentType type) {
        return null;
    }
    
    private final java.lang.String formatStatus(com.railway.qrscanner.data.model.ComponentStatus status) {
        return null;
    }
    
    private final java.lang.String formatInspectionStatus(com.railway.qrscanner.data.model.InspectionStatus status) {
        return null;
    }
    
    private final int getStatusColor(com.railway.qrscanner.data.model.ComponentStatus status) {
        return 0;
    }
    
    private final int getInspectionStatusColor(com.railway.qrscanner.data.model.InspectionStatus status) {
        return 0;
    }
    
    private final java.lang.String formatDate(java.lang.String dateString) {
        return null;
    }
}