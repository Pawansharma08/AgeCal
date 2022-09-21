package com.example.agecal

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var selectDate: TextView
    private lateinit var calsiBtn: Button
    private lateinit var showAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDate = findViewById(R.id.selectDate)
        calsiBtn = findViewById(R.id.calsi)
        showAge = findViewById(R.id.showAge)
    }



    fun selectDate(view: View) {
        var c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        val calDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
                cDay = day
                cMonth = month
                cYear = year

                calsiBtn.setOnClickListener {
                    val y : Int
                    val m : Int
                    val d : Int
                    val currentyear = Calendar.getInstance().get(Calendar.YEAR)

                    if(cYear > currentyear)
                    {
                        y=0
                    }
                    else{
                        y = currentyear-cYear
                    }

                    val currentmonth = Calendar.getInstance().get(Calendar.MONTH)

                    if(cMonth > currentmonth)
                    {
                        m =cMonth
                    }
                    else{
                        m = currentmonth-cMonth
                    }

                    val currentday = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

                    if(cDay > currentday)
                    {
                        d =cDay - currentday
                    }
                    else{
                        d = currentday-cDay
                    }

                    showAge.text=" Your Age is: year : $y month : $m day : $d "

                }
                selectDate.text = "Your Selected Date is: $cDay/${cMonth+1}/$cYear"
            },cYear,cMonth,cDay
        )
        calDialog.show()
    }
}