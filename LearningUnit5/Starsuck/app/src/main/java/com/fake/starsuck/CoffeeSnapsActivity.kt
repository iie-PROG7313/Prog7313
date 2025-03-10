package com.fake.starsuck

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.fake.starsuck.databinding.ActivityCoffeeSnapsBinding

class CoffeeSnapsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoffeeSnapsBinding
    private val picId = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCoffeeSnapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check and request CAMERA permission
        binding.photoFab.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openCamera()
            } else {
                requestCameraPermission()
            }
        }
    }

    // Open the camera
    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, picId)

    }

    // Request CAMERA permission
    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.CAMERA),
            picId
        )
    }

    // Handle the permission request result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == picId && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera()
        } else {
            // Permission denied - Inform the user
            binding.imgSavedPhoto.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }

    // Handle the captured image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == picId && resultCode == Activity.RESULT_OK) {
            val photo = data?.extras?.get("data") as Bitmap?
            photo?.let {
                binding.imgSavedPhoto.setImageBitmap(it)
            }
        }
    }
}
