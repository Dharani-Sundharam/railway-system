package com.railway.qrscanner.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Entity(tableName = "components")
@Parcelize
data class Component(
    @PrimaryKey
    val serialId: String,
    val componentType: ComponentType,
    val materialSpecification: String?,
    val batchNumber: String?,
    val lotNumber: String?,
    val poNumber: String?,
    val manufacturingDate: String?,
    val dispatchDate: String?,
    val receivingDate: String?,
    val installationDate: String?,
    val warrantyStartDate: String?,
    val warrantyEndDate: String?,
    val currentStatus: ComponentStatus,
    val qrCodePath: String?,
    val vendorId: Int,
    val locationId: Int?,
    val createdAt: String,
    val updatedAt: String?
) : Parcelable

enum class ComponentType {
    ELASTIC_RAIL_CLIP,
    LINER,
    RAIL_PAD,
    SLEEPER
}

enum class ComponentStatus {
    MANUFACTURED,
    SHIPPED,
    RECEIVED,
    INSTALLED,
    IN_SERVICE,
    MAINTENANCE,
    FAILED,
    WITHDRAWN
}
