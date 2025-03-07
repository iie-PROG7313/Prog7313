package com.fake.welcometoandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val welcomeText: TextView = findViewById(R.id.welcomeText)
        val backButton: Button = findViewById(R.id.backButton)

        // Get data from MainActivity
        val userName = intent.getStringExtra("USER_NAME")
        welcomeText.text = "Welcome, $userName!"

        // Navigate back to MainActivity
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Close current activity
        }
    }
}
