package com.fake.starsuck

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.fake.starsuck.databinding.ActivityMainBinding
import com.fake.starsuck.databinding.ActivityMainWithNavDrawerBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainWithNavDrawerBinding
    private lateinit var db: AppDatabase
    private lateinit var productDao: ProductDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(this)
        productDao = db.productDao()

        setupListeners()
        setupNavigation()

        initializeProducts() // Populate the database
    }

    private fun setupListeners() {
        listOf(
            Triple(binding.imgSb1, "Soy Latte", 4.5),
            Triple(binding.imgSb2, "Chocco Frapp", 5.0),
            Triple(binding.imgSb3, "Bottled Americano", 3.5),
            Triple(binding.imgSb4, "Rainbow Frapp", 5.5),
            Triple(binding.imgSb5, "Caramel Frapp", 4.8),
            Triple(binding.imgSb6, "Black Forest Frapp", 6.0)
        ).forEach { (view, name, price) ->
            view.setOnClickListener { saveOrder(name, price) }
        }
    }

    private fun setupNavigation() {
        setSupportActionBar(binding.navToolbar)
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.navToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }

    private fun initializeProducts() {
        lifecycleScope.launch {
            if (productDao.getAllProducts().isEmpty()) {
                productDao.insertAll(
                    listOf(
                        Product(name = "Soy Latte", price = 4.5),
                        Product(name = "Chocco Frapp", price = 5.0),
                        Product(name = "Bottled Americano", price = 3.5),
                        Product(name = "Rainbow Frapp", price = 5.5),
                        Product(name = "Caramel Frapp", price = 4.8),
                        Product(name = "Black Forest Frapp", price = 6.0)
                    )
                )
            }
        }
    }

    private fun saveOrder(name: String, price: Double) {
        lifecycleScope.launch {
            val product = Product(name = name, price = price)
            productDao.insert(product)
            Toast.makeText(this@MainActivity, "Ordered: $name", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, OrderDetailsActivity::class.java)
            intent.putExtra("order", name)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_photo -> startActivity(Intent(this, CoffeeSnapsActivity::class.java))
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(v: View?) {
        // Implement click actions if necessary
    }
}