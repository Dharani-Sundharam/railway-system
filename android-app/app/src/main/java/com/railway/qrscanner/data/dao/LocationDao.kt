package com.railway.qrscanner.data.dao

import androidx.room.*
import com.railway.qrscanner.data.model.Location
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {
    
    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<Location>>
    
    @Query("SELECT * FROM locations WHERE id = :id")
    suspend fun getLocationById(id: Int): Location?
    
    @Query("SELECT * FROM locations WHERE zone = :zone")
    fun getLocationsByZone(zone: String): Flow<List<Location>>
    
    @Query("SELECT * FROM locations WHERE division = :division")
    fun getLocationsByDivision(division: String): Flow<List<Location>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(locations: List<Location>)
    
    @Update
    suspend fun updateLocation(location: Location)
    
    @Delete
    suspend fun deleteLocation(location: Location)
}
