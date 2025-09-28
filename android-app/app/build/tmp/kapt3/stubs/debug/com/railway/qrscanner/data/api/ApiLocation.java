package com.railway.qrscanner.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\'\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J~\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011\u00a8\u0006/"}, d2 = {"Lcom/railway/qrscanner/data/api/ApiLocation;", "", "id", "", "zone", "", "division", "section", "stationCode", "chainage", "trackNumber", "gpsLatitude", "", "gpsLongitude", "createdAt", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getChainage", "()Ljava/lang/String;", "getCreatedAt", "getDivision", "getGpsLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getGpsLongitude", "getId", "()I", "getSection", "getStationCode", "getTrackNumber", "getZone", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/railway/qrscanner/data/api/ApiLocation;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class ApiLocation {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String zone = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String division = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String section = null;
    @com.google.gson.annotations.SerializedName(value = "station_code")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String stationCode = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String chainage = null;
    @com.google.gson.annotations.SerializedName(value = "track_number")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String trackNumber = null;
    @com.google.gson.annotations.SerializedName(value = "gps_latitude")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double gpsLatitude = null;
    @com.google.gson.annotations.SerializedName(value = "gps_longitude")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double gpsLongitude = null;
    @com.google.gson.annotations.SerializedName(value = "created_at")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String createdAt = null;
    
    public ApiLocation(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String zone, @org.jetbrains.annotations.NotNull()
    java.lang.String division, @org.jetbrains.annotations.Nullable()
    java.lang.String section, @org.jetbrains.annotations.Nullable()
    java.lang.String stationCode, @org.jetbrains.annotations.Nullable()
    java.lang.String chainage, @org.jetbrains.annotations.Nullable()
    java.lang.String trackNumber, @org.jetbrains.annotations.Nullable()
    java.lang.Double gpsLatitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double gpsLongitude, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getZone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDivision() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSection() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStationCode() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChainage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTrackNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getGpsLatitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getGpsLongitude() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
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
    public final java.lang.Double component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.railway.qrscanner.data.api.ApiLocation copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String zone, @org.jetbrains.annotations.NotNull()
    java.lang.String division, @org.jetbrains.annotations.Nullable()
    java.lang.String section, @org.jetbrains.annotations.Nullable()
    java.lang.String stationCode, @org.jetbrains.annotations.Nullable()
    java.lang.String chainage, @org.jetbrains.annotations.Nullable()
    java.lang.String trackNumber, @org.jetbrains.annotations.Nullable()
    java.lang.Double gpsLatitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double gpsLongitude, @org.jetbrains.annotations.NotNull()
    java.lang.String createdAt) {
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