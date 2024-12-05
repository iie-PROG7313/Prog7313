package com.fake.starsuck

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
import com.fake.starsuck.databinding.ActivityMainBinding
import com.fake.starsuck.databinding.ActivityMainWithNavDrawerBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    //remove when using compose
    /*private lateinit var img_sb1 : ImageView
    private lateinit var img_sb2 : ImageView
    private lateinit var img_sb3 : ImageView
    private lateinit var img_sb4 : ImageView
    private lateinit var img_sb5 : ImageView
    private lateinit var img_sb6 : ImageView*/

    var order = Order()
    private lateinit var binding: ActivityMainWithNavDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSb1.setOnClickListener(this)
        binding.imgSb2.setOnClickListener(this)
        binding.imgSb3.setOnClickListener(this)
        binding.imgSb4.setOnClickListener(this)
        binding.imgSb5.setOnClickListener(this)
        binding.imgSb6.setOnClickListener(this)

        //remove when adding compose
        /*img_sb1 = findViewById(R.id.img_sb1)
        img_sb2 = findViewById(R.id.img_sb2)
        img_sb3 = findViewById(R.id.img_sb3)
        img_sb4 = findViewById(R.id.img_sb4)
        img_sb5 = findViewById(R.id.img_sb5)
        img_sb6 = findViewById(R.id.img_sb6)*/

        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var toggleOnOff = ActionBarDrawerToggle(this,
            binding.drawerLayout, binding.navToolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()

        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.img_sb1 -> order.productName = "Soy Latte"
            R.id.img_sb2 -> order.productName = "Chocco Frapp"
            R.id.img_sb3 -> order.productName = "Bottled Americano"
            R.id.img_sb4 -> order.productName = "Rainbow Frapp"
            R.id.img_sb5 -> order.productName = "Caramel Frapp"
            R.id.img_sb6 -> order.productName = "Black Forest Frapp"
        }
                Toast.makeText(this@MainActivity,
        "MMM " + order.productName, Toast.LENGTH_SHORT).show()
            openIntent(applicationContext, order.productName,
                OrderDetailsActivity::class.java)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_photo -> openIntent(this, "",
                CoffeeSnapsActivity::class.java)
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        // returning true marks the item as selected
        return true
    }
}