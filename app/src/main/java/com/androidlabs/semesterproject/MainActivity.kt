package com.androidlabs.semesterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.androidlabs.semesterproject.databinding.ActivityMainBinding

class MainActivity: DrawerBaseActivity() {

    var activityMainActivityBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "Bride of Christ - HOME"

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        activityMainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        allocateActivityTitle("Home")
        setContentView(activityMainActivityBinding!!.root)

        // Launch the Donations page when button is clicked
        val donations = findViewById<Button>(R.id.donationsBtn)
        donations.setOnClickListener {
            val intent = Intent(this, Donate::class.java)
            startActivity(intent)
        }

        // Launch the Our Work page when button is clicked
        val work = findViewById<Button>(R.id.workBtn)
        work.setOnClickListener {
            val intent = Intent(this, Work::class.java)
            startActivity(intent)
        }
    }
}