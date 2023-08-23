package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calcButton = findViewById<Button>(R.id.btnCalculate)


        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            val bmi = weight.toFloat()/(height.toFloat()).pow(2) * 703
            Log.d("Main Activity BMI", bmi.toString())
            displayResults(bmi)
        }
    }

    private fun displayResults(bmi: Float){
        val bmiText = findViewById<TextView>(R.id.tvIndex)
        val resultDescription = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)

        // Convert bmi to 2 decimal format
        val bmi2digit = String.format("%.2f", bmi)

        if(bmi < 18.5){
            resultDescription.text = "Under Weight"
        } else if(bmi < 24.9){
            resultDescription.text = "Normal Weight"
        } else if(bmi < 32.9){
            resultDescription.text = "Overweight"
        } else{
            resultDescription.text = "Obese"
        }

        bmiText.text = bmi2digit
        info.text = "Normal range is 18.5 - 24.9"

    }
}