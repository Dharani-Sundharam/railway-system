package com.railway.qrscanner.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00cb\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0002\u0010\u001bJ\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010(J\t\u0010@\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0018H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00fe\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00c6\u0001\u00a2\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00d6\u0001J\t\u0010R\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010)\u001a\u0004\b\'\u0010(R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001d\u00a8\u0006S"}, d2 = {"Lcom/railway/qrscanner/data/api/ApiComponent;", "", "id", "", "serialId", "", "componentType", "materialSpecification", "batchNumber", "lotNumber", "poNumber", "manufacturingDate", "dispatchDate", "receivingDate", "installationDate", "warrantyStartDate", "warrantyEndDate", "currentStatus", "qrCodePath", "vendorId", "locationId", "createdAt", "updatedAt", "vendor", "Lcom/railway/qrscanner/data/api/ApiVendor;", "location", "Lcom/railway/qrscanner/data/api/ApiLocation;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/railway/qrscanner/data/api/ApiVendor;Lcom/railway/qrscanner/data/api/ApiLocation;)V", "getBatchNumber", "()Ljava/lang/String;", "getComponentType", "getCreatedAt", "getCurrentStatus", "getDispatchDate", "getId", "()I", "getInstallationDate", "getLocation", "()Lcom/railway/qrscanner/data/api/ApiLocation;", "getLocationId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLotNumber", "getManufacturingDate", "getMaterialSpecification", "getPoNumber", "getQrCodePath", "getReceivingDate", "getSerialId", "getUpdatedAt", "getVendor", "()Lcom/railway/qrscanner/data/api/ApiVendor;", "getVendorId", "getWarrantyEndDate", "getWarrantyStartDate", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/railway/qrscanner/data/api/ApiVendor;Lcom/railway/qrscanner/data/api/ApiLocation;)Lcom/railway/qrscanner/data/api/ApiComponent;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class ApiComponent {
    private final int id = 0;
    @com.google.gson.annotations.SerializedName(value = "serial_id")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String serialId = null;
    @com.google.gson.annotations.SerializedName(value = "component_type")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String componentType = null;
    @com.google.gson.annotations.SerializedName(value = "material_specification")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String materialSpecification = null;
    @com.google.gson.annotations.SerializedName(value = "batch_number")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String batchNumber = null;
    @com.google.gson.annotations.SerializedName(value = "lot_number")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lotNumber = null;
    @com.google.gson.annotations.SerializedName(value = "po_number")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String poNumber = null;
    @com.google.gson.annotations.SerializedName(value = "manufacturing_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String manufacturingDate = null;
    @com.google.gson.annotations.SerializedName(value = "dispatch_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String dispatchDate = null;
    @com.google.gson.annotations.SerializedName(value = "receiving_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String receivingDate = null;
    @com.google.gson.annotations.SerializedName(value = "installation_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String installationDate = null;
    @com.google.gson.annotations.SerializedName(value = "warranty_start_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String warrantyStartDate = null;
    @com.google.gson.annotations.SerializedName(value = "warranty_end_date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String warrantyEndDate = null;
    @com.google.gson.annotations.SerializedName(value = "current_status")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentStatus = null;
    @com.google.gson.annotations.SerializedName(value = "qr_code_path")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String qrCodePath = null;
    @com.google.gson.annotations.SerializedName(value = "vendor_id")
    private final int vendorId = 0;
    @com.google.gson.annotations.SerializedName(value = "location_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer locationId = null;
    @com.google.gson.annotations.SerializedName(value = "created_at")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdAt = null;
    @com.google.gson.annotations.SerializedName(value = "updated_at")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String updatedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final com.railway.qrscanner.data.api.ApiVendor vendor = null;
    @org.jetbrains.annotations.Nullable()
    private final com.railway.qrscanner.data.api.ApiLocation location = null;
    
    public ApiComponent(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    java.lang.String componentType, @org.jetbrains.annotations.Nullable()
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
    java.lang.String currentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String qrCodePath, int vendorId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer locationId, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt, @org.jetbrains.annotations.Nullable()
    com.railway.qrscanner.data.api.ApiVendor vendor, @org.jetbrains.annotations.Nullable()
    com.railway.qrscanner.data.api.ApiLocation location) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSerialId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getComponentType() {
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
    public final java.lang.String getCurrentStatus() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.railway.qrscanner.data.api.ApiVendor getVendor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.railway.qrscanner.data.api.ApiLocation getLocation() {
        return null;
    }
    
    public final int component1() {
        return 0;
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    public final int component16() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.railway.qrscanner.data.api.ApiVendor component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.railway.qrscanner.data.api.ApiLocation component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
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
    public final com.railway.qrscanner.data.api.ApiComponent copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String serialId, @org.jetbrains.annotations.NotNull()
    java.lang.String componentType, @org.jetbrains.annotations.Nullable()
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
    java.lang.String currentStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String qrCodePath, int vendorId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer locationId, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String updatedAt, @org.jetbrains.annotations.Nullable()
    com.railway.qrscanner.data.api.ApiVendor vendor, @org.jetbrains.annotations.Nullable()
    com.railway.qrscanner.data.api.ApiLocation location) {
        return null;
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
}