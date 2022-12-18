package com.androidlabs.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidlabs.semesterproject.databinding.ActivityAboutBinding
import com.androidlabs.semesterproject.databinding.ActivityWorkBinding

class Work : DrawerBaseActivity() {

    var activityWorkActivityBinding: ActivityWorkBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "OUR WORK"

        super.onCreate(savedInstanceState)
        activityWorkActivityBinding = ActivityWorkBinding.inflate(layoutInflater)
        allocateActivityTitle("Our Work")
        setContentView(activityWorkActivityBinding!!.root)
    }
}