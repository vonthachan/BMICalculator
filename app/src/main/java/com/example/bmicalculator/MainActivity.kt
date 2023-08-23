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
        val bmi2digit = String.format("%.2f", bmi)
        bmiText.text = bmi2digit
        info.text = "Normal range is 18.5 - 24.9"

    }
}