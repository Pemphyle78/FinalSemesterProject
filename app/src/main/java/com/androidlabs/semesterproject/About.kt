package com.androidlabs.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidlabs.semesterproject.databinding.ActivityAboutBinding
import com.androidlabs.semesterproject.databinding.ActivityMainBinding

class About : DrawerBaseActivity() {

    var activityAboutActivityBinding: ActivityAboutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "ABOUT"

        super.onCreate(savedInstanceState)
        activityAboutActivityBinding = ActivityAboutBinding.inflate(layoutInflater)
        allocateActivityTitle("About")
        setContentView(activityAboutActivityBinding!!.root)
    }
}