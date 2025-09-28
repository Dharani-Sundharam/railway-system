package com.railway.qrscanner.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.railway.qrscanner.data.model.Component
import com.railway.qrscanner.data.model.Vendor
import com.railway.qrscanner.data.model.Location
import com.railway.qrscanner.data.model.Inspection
import com.railway.qrscanner.data.dao.ComponentDao
import com.railway.qrscanner.data.dao.VendorDao
import com.railway.qrscanner.data.dao.LocationDao
import com.railway.qrscanner.data.dao.InspectionDao

@Database(
    entities = [Component::class, Vendor::class, Location::class, Inspection::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun componentDao(): ComponentDao
    abstract fun vendorDao(): VendorDao
    abstract fun locationDao(): LocationDao
    abstract fun inspectionDao(): InspectionDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "railway_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
