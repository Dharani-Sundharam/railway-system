package com.railway.qrscanner.ui.details

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.railway.qrscanner.databinding.ActivityComponentDetailsBinding
import com.railway.qrscanner.data.database.AppDatabase
import com.railway.qrscanner.data.model.Component
import com.railway.qrscanner.data.model.Vendor
import com.railway.qrscanner.data.model.Location
import com.railway.qrscanner.data.model.Inspection
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ComponentDetailsActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityComponentDetailsBinding
    private lateinit var database: AppDatabase
    private var componentSerialId: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        database = AppDatabase.getDatabase(this)
        componentSerialId = intent.getStringExtra("component_serial_id")
        
        setupUI()
        loadComponentDetails()
    }
    
    private fun setupUI() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                finish()
            }
            
            btnNewInspection.setOnClickListener {
                // TODO: Implement new inspection
                Toast.makeText(this@ComponentDetailsActivity, "New inspection feature coming soon!", Toast.LENGTH_SHORT).show()
            }
            
            btnViewLocation.setOnClickListener {
                // TODO: Implement location view
                Toast.makeText(this@ComponentDetailsActivity, "Location view feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun loadComponentDetails() {
        componentSerialId?.let { serialId ->
            lifecycleScope.launch {
                try {
                    val component = database.componentDao().getComponentBySerialId(serialId)
                    if (component != null) {
                        displayComponentDetails(component)
                    } else {
                        val totalCount = database.componentDao().getComponentCount()
                        Toast.makeText(this@ComponentDetailsActivity, "Component '$serialId' not found. Total components: $totalCount", Toast.LENGTH_LONG).show()
                        finish()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@ComponentDetailsActivity, "Error loading component: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    
    private suspend fun displayComponentDetails(component: Component) {
        // Load related data
        val vendor = database.vendorDao().getVendorById(component.vendorId)
        val location = component.locationId?.let { database.locationDao().getLocationById(it) }
        val inspections = database.inspectionDao().getInspectionsByComponent(component.serialId.hashCode())
        
        runOnUiThread {
            binding.apply {
                // Basic Information
                tvSerialId.text = component.serialId
                tvComponentType.text = formatComponentType(component.componentType)
                tvStatus.text = formatStatus(component.currentStatus)
                tvStatus.setTextColor(getStatusColor(component.currentStatus))
                
                // Vendor Information
                vendor?.let {
                    tvVendorName.text = it.name
                    tvVendorCode.text = it.vendorCode
                    tvVendorContact.text = it.contactPerson
                    tvVendorPhone.text = it.phone
                    tvVendorEmail.text = it.email
                    tvQualityRating.text = String.format("%.1f/5.0", it.qualityRating)
                }
                
                // Location Information
                location?.let {
                    tvLocationZone.text = it.zone
                    tvLocationDivision.text = it.division
                    tvLocationSection.text = it.section
                    tvLocationStation.text = it.stationCode
                    tvLocationChainage.text = it.chainage
                    tvLocationTrack.text = it.trackNumber
                }
                
                // Dates
                tvManufacturingDate.text = formatDate(component.manufacturingDate)
                tvDispatchDate.text = formatDate(component.dispatchDate)
                tvReceivingDate.text = formatDate(component.receivingDate)
                tvInstallationDate.text = formatDate(component.installationDate)
                tvWarrantyStart.text = formatDate(component.warrantyStartDate)
                tvWarrantyEnd.text = formatDate(component.warrantyEndDate)
                
                // Additional Information
                tvMaterialSpec.text = component.materialSpecification ?: "Not specified"
                tvBatchNumber.text = component.batchNumber ?: "Not specified"
                tvLotNumber.text = component.lotNumber ?: "Not specified"
                tvPoNumber.text = component.poNumber ?: "Not specified"
                
                // Show/hide sections based on data availability
                if (location != null) {
                    locationCard.visibility = android.view.View.VISIBLE
                } else {
                    locationCard.visibility = android.view.View.GONE
                }
                
                // Load inspections
                loadInspections(inspections)
            }
        }
    }
    
    private fun loadInspections(inspections: kotlinx.coroutines.flow.Flow<List<Inspection>>) {
        lifecycleScope.launch {
            inspections.collect { inspectionList ->
                runOnUiThread {
                    if (inspectionList.isNotEmpty()) {
                        binding.inspectionsCard.visibility = android.view.View.VISIBLE
                        binding.tvInspectionCount.text = "${inspectionList.size} inspections"
                        
                        // Show latest inspection
                        val latestInspection = inspectionList.maxByOrNull { it.inspectionDate }
                        latestInspection?.let { inspection ->
                            binding.tvLatestInspectionDate.text = formatDate(inspection.inspectionDate)
                            binding.tvLatestInspectionStatus.text = formatInspectionStatus(inspection.status)
                            binding.tvLatestInspectionStatus.setTextColor(getInspectionStatusColor(inspection.status))
                            binding.tvLatestInspectionType.text = inspection.inspectionType.replaceFirstChar { it.uppercase() }
                        }
                    } else {
                        binding.inspectionsCard.visibility = android.view.View.GONE
                    }
                }
            }
        }
    }
    
    private fun formatComponentType(type: com.railway.qrscanner.data.model.ComponentType): String {
        return when (type) {
            com.railway.qrscanner.data.model.ComponentType.ELASTIC_RAIL_CLIP -> "Elastic Rail Clip"
            com.railway.qrscanner.data.model.ComponentType.LINER -> "Liner"
            com.railway.qrscanner.data.model.ComponentType.RAIL_PAD -> "Rail Pad"
            com.railway.qrscanner.data.model.ComponentType.SLEEPER -> "Sleeper"
        }
    }
    
    private fun formatStatus(status: com.railway.qrscanner.data.model.ComponentStatus): String {
        return when (status) {
            com.railway.qrscanner.data.model.ComponentStatus.MANUFACTURED -> "Manufactured"
            com.railway.qrscanner.data.model.ComponentStatus.SHIPPED -> "Shipped"
            com.railway.qrscanner.data.model.ComponentStatus.RECEIVED -> "Received"
            com.railway.qrscanner.data.model.ComponentStatus.INSTALLED -> "Installed"
            com.railway.qrscanner.data.model.ComponentStatus.IN_SERVICE -> "In Service"
            com.railway.qrscanner.data.model.ComponentStatus.MAINTENANCE -> "Maintenance"
            com.railway.qrscanner.data.model.ComponentStatus.FAILED -> "Failed"
            com.railway.qrscanner.data.model.ComponentStatus.WITHDRAWN -> "Withdrawn"
        }
    }
    
    private fun formatInspectionStatus(status: com.railway.qrscanner.data.model.InspectionStatus): String {
        return when (status) {
            com.railway.qrscanner.data.model.InspectionStatus.PASSED -> "Passed"
            com.railway.qrscanner.data.model.InspectionStatus.FAILED -> "Failed"
            com.railway.qrscanner.data.model.InspectionStatus.PENDING -> "Pending"
            com.railway.qrscanner.data.model.InspectionStatus.MAINTENANCE_REQUIRED -> "Maintenance Required"
        }
    }
    
    private fun getStatusColor(status: com.railway.qrscanner.data.model.ComponentStatus): Int {
        return when (status) {
            com.railway.qrscanner.data.model.ComponentStatus.IN_SERVICE -> android.graphics.Color.parseColor("#4CAF50")
            com.railway.qrscanner.data.model.ComponentStatus.MAINTENANCE -> android.graphics.Color.parseColor("#FF9800")
            com.railway.qrscanner.data.model.ComponentStatus.FAILED -> android.graphics.Color.parseColor("#F44336")
            com.railway.qrscanner.data.model.ComponentStatus.WITHDRAWN -> android.graphics.Color.parseColor("#9E9E9E")
            else -> android.graphics.Color.parseColor("#2196F3")
        }
    }
    
    private fun getInspectionStatusColor(status: com.railway.qrscanner.data.model.InspectionStatus): Int {
        return when (status) {
            com.railway.qrscanner.data.model.InspectionStatus.PASSED -> android.graphics.Color.parseColor("#4CAF50")
            com.railway.qrscanner.data.model.InspectionStatus.FAILED -> android.graphics.Color.parseColor("#F44336")
            com.railway.qrscanner.data.model.InspectionStatus.PENDING -> android.graphics.Color.parseColor("#FF9800")
            com.railway.qrscanner.data.model.InspectionStatus.MAINTENANCE_REQUIRED -> android.graphics.Color.parseColor("#FF5722")
        }
    }
    
    private fun formatDate(dateString: String?): String {
        if (dateString == null) return "Not specified"
        
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            outputFormat.format(date ?: Date())
        } catch (e: Exception) {
            dateString
        }
    }
}
