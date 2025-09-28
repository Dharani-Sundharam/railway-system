package com.railway.qrscanner.data.repository

import android.content.Context
import com.railway.qrscanner.data.api.ApiClient
import com.railway.qrscanner.data.api.ApiComponent
import com.railway.qrscanner.data.database.AppDatabase
import com.railway.qrscanner.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class ComponentRepository(private val context: Context) {
    
    private val database = AppDatabase.getDatabase(context)
    private val apiService = ApiClient.apiService
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    
    suspend fun getComponentBySerialId(serialId: String): Component? = withContext(Dispatchers.IO) {
        // First try local database
        val localComponent = database.componentDao().getComponentBySerialId(serialId)
        if (localComponent != null) {
            return@withContext localComponent
        }
        
        // If not found locally, try to fetch from API
        try {
            val response = apiService.getComponentBySerialId(serialId)
            if (response.isSuccessful && response.body() != null) {
                val apiComponent = response.body()!!
                val component = convertApiComponentToLocal(apiComponent)
                
                // Save to local database for future use
                database.componentDao().insertComponent(component)
                
                // Also save vendor and location if they exist
                apiComponent.vendor?.let { vendor ->
                    val localVendor = convertApiVendorToLocal(vendor)
                    database.vendorDao().insertVendor(localVendor)
                }
                
                apiComponent.location?.let { location ->
                    val localLocation = convertApiLocationToLocal(location)
                    database.locationDao().insertLocation(localLocation)
                }
                
                return@withContext component
            }
        } catch (e: Exception) {
            // Log error but don't crash
            e.printStackTrace()
        }
        
        return@withContext null
    }
    
    suspend fun syncComponentsFromServer(): Boolean = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getComponents(limit = 1000) // Get all components
            if (response.isSuccessful && response.body() != null) {
                val apiComponents = response.body()!!
                
                // Convert and save to local database
                val components = apiComponents.map { convertApiComponentToLocal(it) }
                database.componentDao().insertComponents(components)
                
                // Save vendors and locations
                val vendors = apiComponents.mapNotNull { it.vendor }.distinctBy { it.id }
                    .map { convertApiVendorToLocal(it) }
                if (vendors.isNotEmpty()) {
                    database.vendorDao().insertVendors(vendors)
                }
                
                val locations = apiComponents.mapNotNull { it.location }.distinctBy { it.id }
                    .map { convertApiLocationToLocal(it) }
                if (locations.isNotEmpty()) {
                    database.locationDao().insertLocations(locations)
                }
                
                return@withContext true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        
        return@withContext false
    }
    
    suspend fun getComponentCount(): Int = withContext(Dispatchers.IO) {
        return@withContext database.componentDao().getComponentCount()
    }
    
    suspend fun getFirstComponent(): Component? = withContext(Dispatchers.IO) {
        return@withContext database.componentDao().getFirstComponent()
    }
    
    private fun convertApiComponentToLocal(apiComponent: ApiComponent): Component {
        return Component(
            serialId = apiComponent.serialId,
            componentType = ComponentType.valueOf(apiComponent.componentType),
            materialSpecification = apiComponent.materialSpecification,
            batchNumber = apiComponent.batchNumber,
            lotNumber = apiComponent.lotNumber,
            poNumber = apiComponent.poNumber,
            manufacturingDate = apiComponent.manufacturingDate,
            dispatchDate = apiComponent.dispatchDate,
            receivingDate = apiComponent.receivingDate,
            installationDate = apiComponent.installationDate,
            warrantyStartDate = apiComponent.warrantyStartDate,
            warrantyEndDate = apiComponent.warrantyEndDate,
            currentStatus = ComponentStatus.valueOf(apiComponent.currentStatus),
            qrCodePath = apiComponent.qrCodePath,
            vendorId = apiComponent.vendorId,
            locationId = apiComponent.locationId,
            createdAt = apiComponent.createdAt,
            updatedAt = apiComponent.updatedAt
        )
    }
    
    private fun convertApiVendorToLocal(apiVendor: com.railway.qrscanner.data.api.ApiVendor): Vendor {
        return Vendor(
            id = apiVendor.id,
            vendorCode = apiVendor.vendorCode,
            name = apiVendor.name,
            address = apiVendor.address,
            contactPerson = apiVendor.contactPerson,
            phone = apiVendor.phone,
            email = apiVendor.email,
            certificationStatus = apiVendor.certificationStatus,
            qualityRating = apiVendor.qualityRating,
            createdAt = apiVendor.createdAt
        )
    }
    
    private fun convertApiLocationToLocal(apiLocation: com.railway.qrscanner.data.api.ApiLocation): Location {
        return Location(
            id = apiLocation.id,
            zone = apiLocation.zone,
            division = apiLocation.division,
            section = apiLocation.section,
            stationCode = apiLocation.stationCode,
            chainage = apiLocation.chainage,
            trackNumber = apiLocation.trackNumber,
            gpsLatitude = apiLocation.gpsLatitude,
            gpsLongitude = apiLocation.gpsLongitude,
            createdAt = apiLocation.createdAt
        )
    }
}
