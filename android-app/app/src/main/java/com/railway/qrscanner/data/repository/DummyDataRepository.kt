package com.railway.qrscanner.data.repository

import android.content.Context
import com.railway.qrscanner.data.database.AppDatabase
import com.railway.qrscanner.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

class DummyDataRepository(private val context: Context) {
    
    private val database = AppDatabase.getDatabase(context)
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    
    suspend fun populateDummyData() = withContext(Dispatchers.IO) {
        // Check if data already exists
        val existingComponents = database.componentDao().getComponentCount()
        if (existingComponents > 0) return@withContext
        
        // Create dummy vendors
        val vendors = createDummyVendors()
        database.vendorDao().insertVendors(vendors)
        
        // Create dummy locations
        val locations = createDummyLocations()
        database.locationDao().insertLocations(locations)
        
        // Create dummy components
        val components = createDummyComponents(vendors, locations)
        database.componentDao().insertComponents(components)
        
        // Create dummy inspections
        val inspections = createDummyInspections(components)
        database.inspectionDao().insertInspections(inspections)
    }
    
    private fun createDummyVendors(): List<Vendor> {
        val currentTime = dateFormat.format(Date())
        return listOf(
            Vendor(
                id = 1,
                vendorCode = "RAIL001",
                name = "Bharat Rail Components Ltd",
                address = "Plot 123, Industrial Area, Pune, Maharashtra 411019",
                contactPerson = "Suresh Gupta",
                phone = "+91-20-2345-6789",
                email = "contact@bharatrail.com",
                certificationStatus = "active",
                qualityRating = 4.2,
                createdAt = currentTime
            ),
            Vendor(
                id = 2,
                vendorCode = "STEEL002",
                name = "Indian Steel Fittings Pvt Ltd",
                address = "Sector 15, Industrial Estate, Chennai, Tamil Nadu 600032",
                contactPerson = "Lakshmi Narayanan",
                phone = "+91-44-2876-5432",
                email = "info@indiansteel.co.in",
                certificationStatus = "active",
                qualityRating = 3.8,
                createdAt = currentTime
            ),
            Vendor(
                id = 3,
                vendorCode = "METRO003",
                name = "Metro Rail Solutions",
                address = "Block A, Tech Park, Gurgaon, Haryana 122001",
                contactPerson = "Vikram Singh",
                phone = "+91-124-4567-890",
                email = "sales@metrorail.in",
                certificationStatus = "active",
                qualityRating = 4.5,
                createdAt = currentTime
            ),
            Vendor(
                id = 4,
                vendorCode = "TRACK004",
                name = "TrackTech Industries",
                address = "Industrial Zone 2, Kolkata, West Bengal 700091",
                contactPerson = "Anita Das",
                phone = "+91-33-2456-7891",
                email = "orders@tracktech.co.in",
                certificationStatus = "active",
                qualityRating = 3.9,
                createdAt = currentTime
            ),
            Vendor(
                id = 5,
                vendorCode = "CLIP005",
                name = "Precision Rail Clips Ltd",
                address = "MIDC Area, Aurangabad, Maharashtra 431001",
                contactPerson = "Ravi Joshi",
                phone = "+91-240-2345-678",
                email = "precision@railclips.com",
                certificationStatus = "active",
                qualityRating = 4.1,
                createdAt = currentTime
            )
        )
    }
    
    private fun createDummyLocations(): List<Location> {
        val currentTime = dateFormat.format(Date())
        return listOf(
            Location(
                id = 1,
                zone = "Western Railway",
                division = "Mumbai Division",
                section = "Mumbai-Pune Section",
                stationCode = "CSTM",
                chainage = "1234/5-6",
                trackNumber = "UP1",
                gpsLatitude = 18.9697,
                gpsLongitude = 72.8205,
                createdAt = currentTime
            ),
            Location(
                id = 2,
                zone = "Southern Railway",
                division = "Chennai Division",
                section = "Chennai-Bangalore Section",
                stationCode = "MAS",
                chainage = "2345/7-8",
                trackNumber = "DN2",
                gpsLatitude = 13.0843,
                gpsLongitude = 80.2705,
                createdAt = currentTime
            ),
            Location(
                id = 3,
                zone = "Northern Railway",
                division = "Delhi Division",
                section = "Delhi-Agra Section",
                stationCode = "NDLS",
                chainage = "3456/9-10",
                trackNumber = "UP3",
                gpsLatitude = 28.6431,
                gpsLongitude = 77.2197,
                createdAt = currentTime
            ),
            Location(
                id = 4,
                zone = "Eastern Railway",
                division = "Kolkata Division",
                section = "Kolkata-Asansol Section",
                stationCode = "KOAA",
                chainage = "4567/11-12",
                trackNumber = "DN1",
                gpsLatitude = 22.5675,
                gpsLongitude = 88.3918,
                createdAt = currentTime
            ),
            Location(
                id = 5,
                zone = "Central Railway",
                division = "Pune Division",
                section = "Pune-Solapur Section",
                stationCode = "PUNE",
                chainage = "5678/13-14",
                trackNumber = "UP2",
                gpsLatitude = 18.5204,
                gpsLongitude = 73.8567,
                createdAt = currentTime
            )
        )
    }
    
    private fun createDummyComponents(vendors: List<Vendor>, locations: List<Location>): List<Component> {
        val currentTime = dateFormat.format(Date())
        val components = mutableListOf<Component>()
        
        val componentTypes = ComponentType.values()
        val componentStatuses = ComponentStatus.values()
        
        // Create 100 sample components
        for (i in 1..100) {
            val componentType = componentTypes.random()
            val vendor = vendors.random()
            val location = locations.random()
            val status = componentStatuses.random()
            
            val mfgDate = getRandomDate(-730, -30) // Last 2 years
            val dispatchDate = getRandomDateAfter(mfgDate, 1, 30)
            val receivingDate = getRandomDateAfter(dispatchDate, 1, 15)
            val installationDate = if (status in listOf(ComponentStatus.INSTALLED, ComponentStatus.IN_SERVICE, ComponentStatus.MAINTENANCE)) {
                getRandomDateAfter(receivingDate, 1, 60)
            } else null
            
            val warrantyStart = mfgDate
            val warrantyEnd = getRandomDateAfter(warrantyStart, 365, 1825) // 1-5 years
            
            val serialId = generateSerialId(componentType, vendor.vendorCode, i)
            
            components.add(
                Component(
                    serialId = serialId,
                    componentType = componentType,
                    materialSpecification = "IS-${(1000..9999).random()}-${(2015..2023).random()}",
                    batchNumber = "B${(100..999).random()}-${mfgDate.substring(0, 7).replace("-", "")}",
                    lotNumber = "L${(10..99).random()}-${mfgDate.substring(2, 10).replace("-", "")}",
                    poNumber = "PO/${vendor.vendorCode}/${(100..999).random()}/23-24",
                    manufacturingDate = mfgDate,
                    dispatchDate = dispatchDate,
                    receivingDate = receivingDate,
                    installationDate = installationDate,
                    warrantyStartDate = warrantyStart,
                    warrantyEndDate = warrantyEnd,
                    currentStatus = status,
                    qrCodePath = "/static/qr_codes/${serialId}.png",
                    vendorId = vendor.id,
                    locationId = location.id,
                    createdAt = currentTime,
                    updatedAt = null
                )
            )
        }
        
        return components
    }
    
    private fun createDummyInspections(components: List<Component>): List<Inspection> {
        val currentTime = dateFormat.format(Date())
        val inspections = mutableListOf<Inspection>()
        
        val inspectionTypes = listOf("manufacturing", "receiving", "periodic", "maintenance", "failure")
        val inspectionStatuses = InspectionStatus.values()
        
        // Create 200 sample inspections
        for (i in 1..200) {
            val component = components.random()
            val inspectionType = inspectionTypes.random()
            val status = inspectionStatuses.random()
            
            val inspectionDate = getRandomDateAfter(
                component.manufacturingDate ?: currentTime,
                0,
                365
            )
            
            val findings = generateFindings(status)
            val recommendations = if (status == InspectionStatus.MAINTENANCE_REQUIRED) {
                "Follow standard maintenance protocol"
            } else null
            
            val nextInspectionDue = getRandomDateAfter(inspectionDate, 30, 180)
            val severityLevel = if (status == InspectionStatus.FAILED) {
                listOf("low", "medium", "high").random()
            } else "low"
            
            inspections.add(
                Inspection(
                    id = i,
                    componentId = components.indexOf(component) + 1,
                    inspectorId = (1..4).random(),
                    inspectionType = inspectionType,
                    inspectionDate = inspectionDate,
                    status = status,
                    findings = findings,
                    recommendations = recommendations,
                    nextInspectionDue = nextInspectionDue,
                    defectCategory = if (status == InspectionStatus.FAILED) "Material Defect" else null,
                    severityLevel = severityLevel,
                    measurements = generateMeasurements(),
                    photos = null,
                    createdAt = currentTime
                )
            )
        }
        
        return inspections
    }
    
    private fun generateSerialId(componentType: ComponentType, vendorCode: String, index: Int): String {
        val typePrefix = when (componentType) {
            ComponentType.ELASTIC_RAIL_CLIP -> "ELA"
            ComponentType.LINER -> "LIN"
            ComponentType.RAIL_PAD -> "PAD"
            ComponentType.SLEEPER -> "SLE"
        }
        val vendorSuffix = vendorCode.takeLast(3)
        return "$typePrefix$vendorSuffix${index.toString().padStart(6, '0')}"
    }
    
    private fun getRandomDate(daysFromNow: Int, daysToNow: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, (daysFromNow..daysToNow).random())
        return dateFormat.format(calendar.time)
    }
    
    private fun getRandomDateAfter(baseDate: String, minDays: Int, maxDays: Int): String {
        val calendar = Calendar.getInstance()
        calendar.time = dateFormat.parse(baseDate) ?: Date()
        calendar.add(Calendar.DAY_OF_YEAR, (minDays..maxDays).random())
        return dateFormat.format(calendar.time)
    }
    
    private fun generateFindings(status: InspectionStatus): String {
        return when (status) {
            InspectionStatus.PASSED -> listOf(
                "Component meets all specifications",
                "Visual inspection satisfactory",
                "No defects observed",
                "All measurements within tolerance"
            ).random()
            InspectionStatus.FAILED -> listOf(
                "Crack observed in component body",
                "Dimensional deviation detected",
                "Surface corrosion present",
                "Material hardness below specification"
            ).random()
            InspectionStatus.MAINTENANCE_REQUIRED -> listOf(
                "Minor surface wear observed",
                "Lubrication required",
                "Cleaning needed",
                "Bolt torque adjustment required"
            ).random()
            InspectionStatus.PENDING -> listOf(
                "Awaiting test results",
                "Further investigation required",
                "Pending approval from supervisor"
            ).random()
        }
    }
    
    private fun generateMeasurements(): String {
        return """
        {
            "tensile_strength": ${Random.nextInt(400, 801)},
            "hardness": ${Random.nextInt(30, 61)},
            "surface_roughness": ${Random.nextDouble(0.5, 3.1)},
            "dimensional_accuracy": ${Random.nextDouble(95.0, 100.0)}
        }
        """.trimIndent()
    }
}
