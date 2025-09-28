package com.railway.qrscanner.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Entity(tableName = "inspections")
@Parcelize
data class Inspection(
    @PrimaryKey
    val id: Int,
    val componentId: Int,
    val inspectorId: Int?,
    val inspectionType: String,
    val inspectionDate: String,
    val status: InspectionStatus,
    val findings: String?,
    val recommendations: String?,
    val nextInspectionDue: String?,
    val defectCategory: String?,
    val severityLevel: String?,
    val measurements: String?,
    val photos: String?,
    val createdAt: String
) : Parcelable

enum class InspectionStatus {
    PASSED,
    FAILED,
    PENDING,
    MAINTENANCE_REQUIRED
}
