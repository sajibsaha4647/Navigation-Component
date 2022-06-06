package com.example.kotlin_navigation_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.nio.channels.AsynchronousFileChannel.open

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var toggle: ActionBarDrawerToggle

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //here is bottom navigation functions
        navController =findNavController(R.id.mainContainerid)
         bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigationId)
        bottomNavigationView.setupWithNavController(navController)

        //here is drower functions
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navViewDrower)
        navigationView.setupWithNavController(navController)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.favFragment-> {
                    if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }else{
                        drawerLayout.openDrawer(GravityCompat.START)
                    }
                    Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.musicFragment->{
                    if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }else{
                        drawerLayout.openDrawer(GravityCompat.START)
                    }
                }
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