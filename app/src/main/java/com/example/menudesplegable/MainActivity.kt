package com.example.menudesplegable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration.Builder(R.id.uno).setOpenableLayout(drawerLayout).build()

        navController = Navigation.findNavController(this,R.id.navigation)

        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
        NavigationUI.setupWithNavController(navigationView,navController)

        if(navigationView != null){
            configurarDrawer(navigationView)
        }
    }

    private fun configurarDrawer(navigation:NavigationView){
        navigation.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.uno -> {
                    Toast.makeText(this, "has pulsado el boton ${it.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    true
                }
                R.id.dos -> {
                    Toast.makeText(this, "has pulsado el boton ${it.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                    true
                }
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController:NavController = Navigation.findNavController(this,R.id.navigation)
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp()
    }
}