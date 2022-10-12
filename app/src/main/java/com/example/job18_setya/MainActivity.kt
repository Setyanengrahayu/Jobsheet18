package com.example.job18_setya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


lateinit var toggle:ActionBarDrawerToggle
lateinit var navView:NavigationView
lateinit var drawer:DrawerLayout

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Navigation Drawer"

        toggle = ActionBarDrawerToggle(this@MainActivity, drawer, 0, 0)


        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navtpfl -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, tpfl())
                fragmentTransaction.commit()
                drawer.close()
            }

            R.id.navto -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, to())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.navpplg -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, pplg())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.navbusana -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, busana())
                fragmentTransaction.commit()
                drawer.close()
            }
            R.id.navkuliner -> {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.content, kuliner())
                fragmentTransaction.commit()
                drawer.close()
            }

        }
        return true
    }

}