package com.railway.qrscanner.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Entity(tableName = "vendors")
@Parcelize
data class Vendor(
    @PrimaryKey
    val id: Int,
    val vendorCode: String,
    val name: String,
    val address: String?,
    val contactPerson: String?,
    val phone: String?,
    val email: String?,
    val certificationStatus: String,
    val qualityRating: Double,
    val createdAt: String
) : Parcelable
