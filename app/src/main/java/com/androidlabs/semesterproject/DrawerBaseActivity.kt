package com.androidlabs.semesterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class DrawerBaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null

    override fun setContentView(view: View) {
        
        drawerLayout = layoutInflater.inflate(R.layout.activity_drawer_base, null) as DrawerLayout

        val container = drawerLayout!!.findViewById<FrameLayout>(R.id.activityContainer)
        container.addView(view)
        super.setContentView(drawerLayout)

        val toolbar = drawerLayout!!.findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolbar)

        val navigationView = drawerLayout!!.findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close)
        drawerLayout!!.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeId -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.donateId -> {
                startActivity(Intent(this, Donate::class.java))
                }
                R.id.donateItemId -> {
                startActivity(Intent(this, ItemsDonations::class.java))
                }
                R.id.volunteerId -> {
                    startActivity(Intent(this, Volunteer::class.java))
                }
                R.id.workId -> {
                    startActivity(Intent(this, Work::class.java))
                }
                R.id.aboutId -> {
                    startActivity(Intent(this, About::class.java))
                }

                R.id.settingsId -> {
                    startActivity(Intent(this, Settings::class.java))
                }
            }
            true
        }
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return false
    }

    protected fun allocateActivityTitle(titleString: String?) {

        if (supportActionBar != null) {
            supportActionBar!!.title = titleString
        }
    }
}