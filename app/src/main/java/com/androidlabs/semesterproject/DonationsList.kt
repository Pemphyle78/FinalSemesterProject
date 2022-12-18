package com.androidlabs.semesterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidlabs.semesterproject.databinding.ActivityDonationsListBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_donations_list.*

class DonationsList : DrawerBaseActivity() {

    var activityDonationsList: ActivityDonationsListBinding? = null
    private lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "DONATIONS from Database"
        super.onCreate(savedInstanceState)

        FirebaseFirestore.setLoggingEnabled(true)

        activityDonationsList = ActivityDonationsListBinding.inflate(layoutInflater)
        allocateActivityTitle("Donations List")
        setContentView(activityDonationsList!!.root)

        database = Firebase.firestore

        loadDataFromDatabase()
    }

    private fun loadDataFromDatabase() {
        database.collection("my-donations")
            .get()
            .addOnCompleteListener {

                val result = StringBuffer()

                if (it.isSuccessful) {
                    for(document in it.result!!) {
                        result
                            .append("ID: " + document.data.getValue("donationId"))
                            .append("\n")
                            .append("Donation Date: " + document.data.getValue("createdAt"))
                            .append("\n")
                            .append("First Name: " + document.data.getValue("firstName"))
                            .append("\n")
                            .append("Last Name: " + document.data.getValue("lastName"))
                            .append("\n")
                            .append("Email address: " + document.data.getValue("emailAddress"))
                            .append("\n")
                            .append("City: " + document.data.getValue("city"))
                            .append("\n")
                            .append("Amount: " + document.data.getValue("amount"))
                            .append("\n\n\n")
                    }
                    textViewResultTf.setText(result)
                }
            }
    }
}