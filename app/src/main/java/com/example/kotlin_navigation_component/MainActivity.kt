package com.example.kotlin_navigation_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.nio.channels.AsynchronousFileChannel.open

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //here is bottom navigation functions
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContainerid) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigationId)
        setupWithNavController(bottomNavigationView,navController)

        //here is drower functions
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView:NavigationView = findViewById(R.id.navViewDrower)
        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.favFragment->Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
            }
            true
        }




    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return  true
        }

        return super.onOptionsItemSelected(item)
    }
}