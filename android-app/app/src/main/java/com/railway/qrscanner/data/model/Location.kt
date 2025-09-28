package com.railway.qrscanner.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Entity(tableName = "locations")
@Parcelize
data class Location(
    @PrimaryKey
    val id: Int,
    val zone: String,
    val division: String,
    val section: String?,
    val stationCode: String?,
    val chainage: String?,
    val trackNumber: String?,
    val gpsLatitude: Double?,
    val gpsLongitude: Double?,
    val createdAt: String
) : Parcelable
