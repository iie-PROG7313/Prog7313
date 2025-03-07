package com.fake.welcometoandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //sets activity to fit the whole screen, without a top bar
        enableEdgeToEdge()
        // Set the XML layout for this Activity
        setContentView(R.layout.activity_main)

        // Connect XML elements to Kotlin using their IDs
        val textView: TextView = findViewById(R.id.textView)    // Displays text
        val editText: EditText = findViewById(R.id.editText)    // Input field
        val button: Button = findViewById(R.id.myButton)        // Button

        // Button click listener
        button.setOnClickListener {
            val userName = editText.text.toString()

            // Update the TextView with the user's name
            textView.text = "Hello, $userName!"

            // Navigate to SecondActivity and pass data
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER_NAME", userName)
            startActivity(intent)

            // Show a quick pop up message
            Toast.makeText(this, "Navigating to second screen!", Toast.LENGTH_SHORT).show()
        }
    }
}