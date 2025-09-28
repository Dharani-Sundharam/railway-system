package com.railway.qrscanner.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00af\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0011H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0014H\u00c6\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00dc\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\t\u0010E\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u00d6\u0003J\t\u0010J\u001a\u00020\u0014H\u00d6\u0001J\t\u0010K\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001a\u00a8\u0006Q"}, d2 = {"Lcom/railway/qrscanner/data/model/Component;", "Landroid/os/Parcelable;", "serialId", "", "componentType", "Lcom/railway/qrscanner/data/model/ComponentType;", "materialSpecification", "batchNumber", "lotNumber", "poNumber", "manufacturingDate", "dispatchDate", "receivingDate", "installationDate", "warrantyStartDate", "warrantyEndDate", "currentStatus", "Lcom/railway/qrscanner/data/model/ComponentStatus;", "qrCodePath", "vendorId", "", "locationId", "createdAt", "updatedAt", "(Ljava/lang/String;Lcom/railway/qrscanner/data/model/ComponentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/railway/qrscanner/data/model/ComponentStatus;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBatchNumber", "()Ljava/lang/String;", "getComponentType", "()Lcom/railway/qrscanner/data/model/ComponentType;", "getCreatedAt", "getCurrentStatus", "()Lcom/railway/qrscanner/data/model/ComponentStatus;", "getDispatchDate", "getInstallationDate", "getLocationId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLotNumber", "getManufacturingDate", "getMaterialSpecification", "getPoNumber", "getQrCodePath", "getReceivingDate", "getSerialId", "getUpdatedAt", "getVendorId", "()I", "getWarrantyEndDate", "getWarrantyStartDate", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/railway/qrscanner/data/model/ComponentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/railway/qrscanner/data/model/ComponentStatus;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/railway/qrscanner/data/model/Component;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
@androidx.room.Entity(tableName = "components")
@kotlinx.parcelize.Parcelize()
public final class Component implements android.os.Parcelable {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String serialId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.railway.qrscanner.data.model.ComponentType componentType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String materialSpecification = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String batchNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lotNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String poNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String manufacturingDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String dispatchDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String receivingDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String installationDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String warrantyStartDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String warrantyEndDate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.railway.qrscanner.data.model.ComponentStatus currentStatus = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String qrCodePath = null;
    private final int vendorId = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer locationId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String updatedAt = null;
    
    public Component(@org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.ComponentType componentType, @org.jetbrains.annotations.Nullable()
    java.lang.String materialSpecification, @org.jetbrains.annotations.Nullable()
    java.lang.String batchNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String lotNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String poNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String manufacturingDate, @org.jetbrains.annotations.Nullable()
    java.lang.String dispatchDate, @org.jetbrains.annotations.Nullable()
    java.lang.String receivingDate, @org.jetbrains.annotations.Nullable()
    java.lang.String installationDate, @org.jetbrains.annotations.Nullable()
    java.lang.String warrantyStartDate, @org.jetbrains.annotations.Nullable()
    java.lang.String warrantyEndDate, @org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.ComponentStatus currentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String qrCodePath, int vendorId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer locationId, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSerialId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.model.ComponentType getComponentType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMaterialSpecification() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBatchNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLotNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPoNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getManufacturingDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDispatchDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceivingDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInstallationDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWarrantyStartDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWarrantyEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.model.ComponentStatus getCurrentStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getQrCodePath() {
        return null;
    }
    
    public final int getVendorId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLocationId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.model.ComponentStatus component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    public final int component15() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.model.ComponentType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.model.Component copy(@org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.ComponentType componentType, @org.jetbrains.annotations.Nullable()
    java.lang.String materialSpecification, @org.jetbrains.annotations.Nullable()
    java.lang.String batchNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String lotNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String poNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String manufacturingDate, @org.jetbrains.annotations.Nullable()
    java.lang.String dispatchDate, @org.jetbrains.annotations.Nullable()
    java.lang.String receivingDate, @org.jetbrains.annotations.Nullable()
    java.lang.String installationDate, @org.jetbrains.annotations.Nullable()
    java.lang.String warrantyStartDate, @org.jetbrains.annotations.Nullable()
    java.lang.String warrantyEndDate, @org.jetbrains.annotations.NotNull()
    com.railway.qrscanner.data.model.ComponentStatus currentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String qrCodePath, int vendorId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer locationId, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt) {
        return null;
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
}