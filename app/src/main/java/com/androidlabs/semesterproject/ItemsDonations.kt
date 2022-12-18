package com.androidlabs.semesterproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.androidlabs.semesterproject.databinding.ActivityDonateBinding
import com.androidlabs.semesterproject.databinding.ActivityItemsDonationsBinding
import kotlinx.android.synthetic.main.activity_items_donations.*

class ItemsDonations : DrawerBaseActivity() {

    lateinit var food: CheckBox
    lateinit var water: CheckBox
    lateinit var toys: CheckBox
    lateinit var toothpaste: CheckBox
    lateinit var soap: CheckBox
    lateinit var electronics: CheckBox
    lateinit var clothes: CheckBox
    lateinit var diapers: CheckBox
    lateinit var hygienic: CheckBox
    lateinit var others: CheckBox

    lateinit var submitBtn: Button
    lateinit var clearBtn: Button

    var activityItemsDonations: ActivityItemsDonationsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        title = "ITEMS DONATIONS"

        super.onCreate(savedInstanceState)
        activityItemsDonations = ActivityItemsDonationsBinding.inflate(layoutInflater)
        allocateActivityTitle("Items Donations")
        setContentView(activityItemsDonations!!.root)

        food = findViewById(R.id.checkbox1)
        water = findViewById(R.id.checkBox2)
        toys = findViewById(R.id.checkBox3)
        toothpaste = findViewById(R.id.checkBox4)
        soap = findViewById(R.id.checkBox5)
        electronics = findViewById(R.id.checkBox6)
        clothes = findViewById(R.id.checkBox7)
        diapers = findViewById(R.id.checkBox8)
        hygienic = findViewById(R.id.checkBox9)
        others = findViewById(R.id.checkBox10)

        submitBtn = findViewById(R.id.itemDonationSubmitBtn)
        clearBtn = findViewById(R.id.itemDonationClearBtn)

        submitBtn.setOnClickListener {
            if (checkbox1.isChecked || checkBox2.isChecked ||checkBox3.isChecked || checkBox4.isChecked || checkBox5.isChecked || checkBox6.isChecked || checkBox7.isChecked || checkBox8.isChecked || checkBox9.isChecked || checkBox10.isChecked) {
                val handler = Handler()
                handler.postDelayed({
                    val intent = Intent(this, ThankYouDonation::class.java)
                    startActivity(intent)
                    finish()
                }, 1500)
            } else {
                val toast = Toast.makeText(applicationContext, "Please select at least one item.", Toast.LENGTH_SHORT)
                toast.show()
            }

        }

        clearBtn.setOnClickListener {
            checkbox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
            checkBox4.isChecked = false
            checkBox5.isChecked = false
            checkBox6.isChecked = false
            checkBox7.isChecked = false
            checkBox8.isChecked = false
            checkBox9.isChecked = false
            checkBox10.isChecked = false
        }
    }
}