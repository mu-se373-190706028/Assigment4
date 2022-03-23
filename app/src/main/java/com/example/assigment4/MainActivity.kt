package com.example.assigment4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.math.abs
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        //Setting views with findViewById
        val button = findViewById<Button>(R.id.datepickerbutton)
        val allInfo = findViewById<TextView>(R.id.allInfoText)
        val calendarText = findViewById<TextView>(R.id.calenderText)
        val ageText = findViewById<TextView>(R.id.ageText)
        val headerText = findViewById<TextView>(R.id.headerText)
        //Setting Calendar
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val minute = c.get(Calendar.MINUTE)

        //Setting button click to open Calendar dialog
        button.setOnClickListener {
            val dateDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, yYear, mMonth, dDay ->
                calendarText.text ="${dDay}/${mMonth+1}/${yYear}"
                allInfo.text = "${year - yYear},${abs(month - mMonth)}, ${abs(day-dDay)},${minute}"
                ageText.text = "${year-yYear}"
                headerText.text="YOUR AGE IS"
            },year,month,day)
                dateDialog.show()
        }
    }
}