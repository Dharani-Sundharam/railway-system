package com.railway.qrscanner.data.dao

import androidx.room.*
import com.railway.qrscanner.data.model.Inspection
import kotlinx.coroutines.flow.Flow

@Dao
interface InspectionDao {
    
    @Query("SELECT * FROM inspections")
    fun getAllInspections(): Flow<List<Inspection>>
    
    @Query("SELECT * FROM inspections WHERE id = :id")
    suspend fun getInspectionById(id: Int): Inspection?
    
    @Query("SELECT * FROM inspections WHERE componentId = :componentId")
    fun getInspectionsByComponent(componentId: Int): Flow<List<Inspection>>
    
    @Query("SELECT * FROM inspections WHERE inspectorId = :inspectorId")
    fun getInspectionsByInspector(inspectorId: Int): Flow<List<Inspection>>
    
    @Query("SELECT * FROM inspections WHERE status = :status")
    fun getInspectionsByStatus(status: String): Flow<List<Inspection>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInspection(inspection: Inspection)
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInspections(inspections: List<Inspection>)
    
    @Update
    suspend fun updateInspection(inspection: Inspection)
    
    @Delete
    suspend fun deleteInspection(inspection: Inspection)
}
