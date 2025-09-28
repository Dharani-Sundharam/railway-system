package com.railway.qrscanner.data.dao

import androidx.room.*
import com.railway.qrscanner.data.model.Component
import kotlinx.coroutines.flow.Flow

@Dao
interface ComponentDao {
    
    @Query("SELECT * FROM components")
    fun getAllComponents(): Flow<List<Component>>
    
    @Query("SELECT * FROM components WHERE serialId = :serialId")
    suspend fun getComponentBySerialId(serialId: String): Component?
    
    @Query("SELECT * FROM components WHERE componentType = :type")
    fun getComponentsByType(type: String): Flow<List<Component>>
    
    @Query("SELECT * FROM components WHERE currentStatus = :status")
    fun getComponentsByStatus(status: String): Flow<List<Component>>
    
    @Query("SELECT * FROM components WHERE vendorId = :vendorId")
    fun getComponentsByVendor(vendorId: Int): Flow<List<Component>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComponent(component: Component)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComponents(components: List<Component>)
    
    @Update
    suspend fun updateComponent(component: Component)
    
    @Delete
    suspend fun deleteComponent(component: Component)
    
    @Query("SELECT COUNT(*) FROM components")
    suspend fun getComponentCount(): Int
    
    @Query("SELECT COUNT(*) FROM components WHERE componentType = :type")
    suspend fun getComponentCountByType(type: String): Int
    
    @Query("SELECT * FROM components LIMIT 1")
    suspend fun getFirstComponent(): Component?
}
