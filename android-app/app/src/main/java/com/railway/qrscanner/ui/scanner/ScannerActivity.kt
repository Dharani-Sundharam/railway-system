package com.railway.qrscanner.ui.scanner

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.zxing.Result
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView
import com.railway.qrscanner.databinding.ActivityScannerBinding
import com.railway.qrscanner.data.database.AppDatabase
import com.railway.qrscanner.data.model.Component
import com.railway.qrscanner.data.repository.ComponentRepository
import com.railway.qrscanner.ui.details.ComponentDetailsActivity
import kotlinx.coroutines.launch
import androidx.core.content.ContextCompat.getDrawable

class ScannerActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityScannerBinding
    private lateinit var database: AppDatabase
    private lateinit var componentRepository: ComponentRepository
    private var isScanning = false
    private var isTorchOn = false
    
    companion object {
        private const val CAMERA_PERMISSION_REQUEST = 1001
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        database = AppDatabase.getDatabase(this)
        componentRepository = ComponentRepository(this)
        
        setupUI()
        checkCameraPermission()
    }
    
    private fun setupUI() {
        binding.apply {
            toolbar.setNavigationOnClickListener {
                finish()
            }
            
            btnFlash.setOnClickListener {
                toggleFlash()
            }
            
            btnGallery.setOnClickListener {
                // TODO: Implement gallery scan
                Toast.makeText(this@ScannerActivity, "Gallery scan coming soon!", Toast.LENGTH_SHORT).show()
            }
        }
        
        setupBarcodeScanner()
    }
    
    private fun setupBarcodeScanner() {
        binding.barcodeScanner.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                if (result != null && !isScanning) {
                    isScanning = true
                    handleScanResult(result.text)
                }
            }
            
            override fun possibleResultPoints(resultPoints: MutableList<com.google.zxing.ResultPoint>?) {
                // Handle possible result points if needed
            }
        })
    }
    
    private fun handleScanResult(scanResult: String) {
        // Show loading
        binding.progressBar.visibility = android.view.View.VISIBLE
        binding.tvScanResult.text = "Processing scan result..."
        
        lifecycleScope.launch {
            try {
                // Extract component ID from QR code URL
                val componentId = extractComponentId(scanResult)
                
                if (componentId != null) {
                    // Open web interface with component details
                    val webUrl = "http://192.168.33.64:3000/components/$componentId"
                    openWebInterface(webUrl)
                } else {
                    // Try to look up component using repository (checks local DB first, then API)
                    val component = componentRepository.getComponentBySerialId(scanResult)
                    
                    if (component != null) {
                        // Component found, navigate to details
                        val intent = Intent(this@ScannerActivity, ComponentDetailsActivity::class.java)
                        intent.putExtra("component_serial_id", component.serialId)
                        startActivity(intent)
                        finish()
                    } else {
                        // Component not found
                        runOnUiThread {
                            binding.progressBar.visibility = android.view.View.GONE
                            binding.tvScanResult.text = "Component not found: $scanResult"
                            binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.holo_red_dark))
                            
                            // Reset scanning after 2 seconds
                            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                                isScanning = false
                                binding.tvScanResult.text = "Point camera at QR code"
                                binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.white))
                            }, 2000)
                        }
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    binding.progressBar.visibility = android.view.View.GONE
                    binding.tvScanResult.text = "Error: ${e.message}"
                    binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.holo_red_dark))
                    
                    // Reset scanning after 2 seconds
                    android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                        isScanning = false
                        binding.tvScanResult.text = "Point camera at QR code"
                        binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.white))
                    }, 2000)
                }
            }
        }
    }
    
    private fun extractComponentId(qrResult: String): String? {
        // Extract component ID from URL like "https://rail.id/i/LIN005000047"
        return try {
            val parts = qrResult.split("/")
            if (parts.size >= 2 && parts.last().isNotEmpty()) {
                parts.last()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
    
    private fun openWebInterface(url: String) {
        runOnUiThread {
            binding.progressBar.visibility = android.view.View.GONE
            binding.tvScanResult.text = "Opening web interface..."
            binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.holo_green_dark))
            
            try {
                val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(url))
                startActivity(intent)
                
                // Reset scanning after 2 seconds
                android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                    isScanning = false
                    binding.tvScanResult.text = "Point camera at QR code"
                    binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.white))
                }, 2000)
            } catch (e: Exception) {
                binding.tvScanResult.text = "Error opening web interface: ${e.message}"
                binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.holo_red_dark))
                
                // Reset scanning after 2 seconds
                android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                    isScanning = false
                    binding.tvScanResult.text = "Point camera at QR code"
                    binding.tvScanResult.setTextColor(ContextCompat.getColor(this@ScannerActivity, android.R.color.white))
                }, 2000)
            }
        }
    }
    
    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) 
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_REQUEST
            )
        } else {
            startScanning()
        }
    }
    
    private fun startScanning() {
        binding.barcodeScanner.resume()
    }
    
    private fun stopScanning() {
        binding.barcodeScanner.pause()
    }
    
    private fun toggleFlash() {
        if (isTorchOn) {
            binding.barcodeScanner.setTorchOff()
            binding.btnFlash.setIcon(getDrawable(this, com.railway.qrscanner.R.drawable.ic_flash_off))
        } else {
            binding.barcodeScanner.setTorchOn()
            binding.btnFlash.setIcon(getDrawable(this, com.railway.qrscanner.R.drawable.ic_flash_on))
        }
        isTorchOn = !isTorchOn
    }
    
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        
        when (requestCode) {
            CAMERA_PERMISSION_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startScanning()
                } else {
                    Toast.makeText(this, "Camera permission is required for QR scanning", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) 
            == PackageManager.PERMISSION_GRANTED) {
            startScanning()
        }
    }
    
    override fun onPause() {
        super.onPause()
        stopScanning()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        binding.barcodeScanner.pause()
    }
}
