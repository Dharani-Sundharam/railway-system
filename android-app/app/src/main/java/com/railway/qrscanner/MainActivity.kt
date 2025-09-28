package com.railway.qrscanner

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.railway.qrscanner.databinding.ActivityMainBinding
import com.railway.qrscanner.data.repository.DummyDataRepository
import com.railway.qrscanner.data.repository.ComponentRepository
import com.railway.qrscanner.ui.scanner.ScannerActivity
import com.railway.qrscanner.ui.details.ComponentDetailsActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var dummyDataRepository: DummyDataRepository
    private lateinit var componentRepository: ComponentRepository
    
    private suspend fun getComponentCount(): Int {
        return componentRepository.getComponentCount()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        dummyDataRepository = DummyDataRepository(this)
        componentRepository = ComponentRepository(this)
        
        setupUI()
        populateDummyData()
        syncWithServer()
    }
    
    private fun setupUI() {
        binding.apply {
            btnScanQr.setOnClickListener {
                startActivity(Intent(this@MainActivity, ScannerActivity::class.java))
            }
            
            btnViewComponents.setOnClickListener {
                // Show the first component from the database
                lifecycleScope.launch {
                    try {
                        val firstComponent = componentRepository.getFirstComponent()
                        if (firstComponent != null) {
                            val intent = Intent(this@MainActivity, ComponentDetailsActivity::class.java)
                            intent.putExtra("component_serial_id", firstComponent.serialId)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@MainActivity, "No components found in database", Toast.LENGTH_SHORT).show()
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, "Error getting component: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            
            btnViewInspections.setOnClickListener {
                Toast.makeText(this@MainActivity, "Inspections feature coming soon!", Toast.LENGTH_SHORT).show()
            }
            
            btnAnalytics.setOnClickListener {
                Toast.makeText(this@MainActivity, "Analytics feature coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun populateDummyData() {
        lifecycleScope.launch {
            try {
                dummyDataRepository.populateDummyData()
                val count = getComponentCount()
                Toast.makeText(this@MainActivity, "Database initialized with $count components", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error initializing database: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
    
    private fun syncWithServer() {
        lifecycleScope.launch {
            try {
                val success = componentRepository.syncComponentsFromServer()
                if (success) {
                    Toast.makeText(this@MainActivity, "Synced with server successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Failed to sync with server - using local data", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Server sync error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
