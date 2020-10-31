package com.example.bmicalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val etWeight = findViewById<EditText>(R.id.et_weight)
        val etHeight = findViewById<EditText>(R.id.et_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val tvOutput = findViewById<TextView>(R.id.tv_output)

        tvOutput.visibility = View.INVISIBLE

        val actionBar = supportActionBar
        actionBar!!.title = "Body Mass Index"
        actionBar.setDisplayHomeAsUpEnabled(true)

        btnCalculate.setOnClickListener {
            val weight = etWeight.text.toString().toFloat()
            val height = etHeight.text.toString().toFloat() / 100
            val bmi = (weight)/(height*height)

            tvOutput.visibility = View.VISIBLE
            tvOutput.text = "BMI is $bmi and you are ${bmiResult(bmi)}"
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun bmiResult(bmi:Float): String{

        return if(bmi<18.5)
            "Underweight"
        else if(bmi>18.5 && bmi<24.9)
            "Normal"
        else if(bmi>25 && bmi<29.9)
            "Overweight"
        else
            "Obese"
    }
}