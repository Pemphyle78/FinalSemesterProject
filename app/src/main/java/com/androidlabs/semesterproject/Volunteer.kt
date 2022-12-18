package com.androidlabs.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.androidlabs.semesterproject.databinding.ActivityAboutBinding
import com.androidlabs.semesterproject.databinding.ActivityVolunteerBinding
import kotlinx.android.synthetic.main.activity_volunteer.*

class Volunteer : DrawerBaseActivity() {

    var activityVolunteerActivityBinding: ActivityVolunteerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "VOLUNTEERS"

        super.onCreate(savedInstanceState)
        activityVolunteerActivityBinding = ActivityVolunteerBinding.inflate(layoutInflater)
        allocateActivityTitle("Volunteers")
        setContentView(activityVolunteerActivityBinding!!.root)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Pemphile Nzuzi", "David Sharma", "Steve Smith",
            "Roberto Williamson", "Ross Taylor", "Paul Gutierrez", "Samantha Roth", "Hunter Swanson",
            "Kane Depaul", "Valerie Kidron", "Salomon M. Nzuzi", "India Ahmed", "Alexandria Cortez",
            "Vladimir Laitanan", "Jack B. Bauer"
        )

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        refreshApp()
    }

    private fun refreshApp() {
        swipeToRefresh.setOnRefreshListener {
            Toast.makeText(this, "Refreshed!", Toast.LENGTH_SHORT).show()

            swipeToRefresh.isRefreshing = false
        }
    }
}