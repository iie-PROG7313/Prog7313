package com.fake.starsuck

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fake.starsuck.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productName = intent.getStringExtra("order") ?: "Unknown"
        binding.tvPlacedOrder.text = productName

        val imageRes = when (productName) {
            "Soy Latte" -> R.drawable.sb1
            "Chocco Frapp" -> R.drawable.sb2
            "Bottled Americano" -> R.drawable.sb3
            "Rainbow Frapp" -> R.drawable.sb4
            "Caramel Frapp" -> R.drawable.sb5
            "Black Forest Frapp" -> R.drawable.sb6
            else -> R.drawable.starsuckslogo
        }

        binding.imgOrderedBeverage.setImageResource(imageRes)

        binding.fabOrder.setOnClickListener {
            shareIntent(applicationContext, productName)
        }
    }
}