package com.railway.qrscanner.data.api

import com.google.gson.annotations.SerializedName
import java.util.Date

// API Response Models matching backend schemas
data class ApiComponent(
    val id: Int,
    @SerializedName("serial_id")
    val serialId: String,
    @SerializedName("component_type")
    val componentType: String,
    @SerializedName("material_specification")
    val materialSpecification: String?,
    @SerializedName("batch_number")
    val batchNumber: String?,
    @SerializedName("lot_number")
    val lotNumber: String?,
    @SerializedName("po_number")
    val poNumber: String?,
    @SerializedName("manufacturing_date")
    val manufacturingDate: String?,
    @SerializedName("dispatch_date")
    val dispatchDate: String?,
    @SerializedName("receiving_date")
    val receivingDate: String?,
    @SerializedName("installation_date")
    val installationDate: String?,
    @SerializedName("warranty_start_date")
    val warrantyStartDate: String?,
    @SerializedName("warranty_end_date")
    val warrantyEndDate: String?,
    @SerializedName("current_status")
    val currentStatus: String,
    @SerializedName("qr_code_path")
    val qrCodePath: String?,
    @SerializedName("vendor_id")
    val vendorId: Int,
    @SerializedName("location_id")
    val locationId: Int?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String?,
    val vendor: ApiVendor?,
    val location: ApiLocation?
)

data class ApiVendor(
    val id: Int,
    @SerializedName("vendor_code")
    val vendorCode: String,
    val name: String,
    val address: String?,
    @SerializedName("contact_person")
    val contactPerson: String?,
    val phone: String?,
    val email: String?,
    @SerializedName("certification_status")
    val certificationStatus: String,
    @SerializedName("quality_rating")
    val qualityRating: Double,
    @SerializedName("created_at")
    val createdAt: String
)

data class ApiLocation(
    val id: Int,
    val zone: String,
    val division: String,
    val section: String?,
    @SerializedName("station_code")
    val stationCode: String?,
    val chainage: String?,
    @SerializedName("track_number")
    val trackNumber: String?,
    @SerializedName("gps_latitude")
    val gpsLatitude: Double?,
    @SerializedName("gps_longitude")
    val gpsLongitude: Double?,
    @SerializedName("created_at")
    val createdAt: String
)

data class ApiInspection(
    val id: Int,
    @SerializedName("component_id")
    val componentId: Int,
    @SerializedName("inspector_id")
    val inspectorId: Int?,
    @SerializedName("inspection_type")
    val inspectionType: String,
    @SerializedName("inspection_date")
    val inspectionDate: String,
    val status: String,
    val findings: String?,
    val recommendations: String?,
    @SerializedName("next_inspection_due")
    val nextInspectionDue: String?,
    @SerializedName("defect_category")
    val defectCategory: String?,
    @SerializedName("severity_level")
    val severityLevel: String?,
    val measurements: String?,
    val photos: String?,
    @SerializedName("created_at")
    val createdAt: String
)

// API Error Response
data class ApiError(
    val detail: String
)
