package com.railway.qrscanner.data.dao

import androidx.room.*
import com.railway.qrscanner.data.model.Vendor
import kotlinx.coroutines.flow.Flow

@Dao
interface VendorDao {
    
    @Query("SELECT * FROM vendors")
    fun getAllVendors(): Flow<List<Vendor>>
    
    @Query("SELECT * FROM vendors WHERE id = :id")
    suspend fun getVendorById(id: Int): Vendor?
    
    @Query("SELECT * FROM vendors WHERE vendorCode = :vendorCode")
    suspend fun getVendorByCode(vendorCode: String): Vendor?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVendor(vendor: Vendor)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVendors(vendors: List<Vendor>)
    
    @Update
    suspend fun updateVendor(vendor: Vendor)
    
    @Delete
    suspend fun deleteVendor(vendor: Vendor)
}
