package com.androidlabs.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidlabs.semesterproject.databinding.ActivityAboutBinding
import com.androidlabs.semesterproject.databinding.ActivitySettingsBinding

class Settings : DrawerBaseActivity() {

    var activitySettingsActivityBinding: ActivitySettingsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "SETTINGS"

        super.onCreate(savedInstanceState)
        activitySettingsActivityBinding = ActivitySettingsBinding.inflate(layoutInflater)
        allocateActivityTitle("Settings")
        setContentView(activitySettingsActivityBinding!!.root)

        if (findViewById<View?>(R.id.idFrameLayout) != null) {
            if (savedInstanceState != null) {
                return
            }
            // below line is to inflate our fragment.
            fragmentManager.beginTransaction().add(R.id.idFrameLayout, SettingsFragment()).commit()
        }
    }
}