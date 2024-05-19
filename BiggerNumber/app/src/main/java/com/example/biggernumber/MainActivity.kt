package com.example.biggernumber

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var btnLeft: Button
    private lateinit var btnRight: Button
    private lateinit var backgroundView: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        btnLeft = findViewById(R.id.btnLeft)
        btnRight = findViewById(R.id.btnRight)
        backgroundView = findViewById(R.id.backgroundView)

        btnLeft.setOnClickListener {
            handleButtonClick(isLeftButton = true)
        }

        btnRight.setOnClickListener {
            handleButtonClick(isLeftButton = false)
        }

        // Set initial random numbers
        setRandomNumbers()
    }

    private fun handleButtonClick(isLeftButton: Boolean) {
        // Compare the numbers in the boxes
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()
        if ((isLeftButton && leftNum > rightNum) || (!isLeftButton && rightNum > leftNum)) {
            // Correct answer
            backgroundView.setBackgroundColor(Color.CYAN)
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
        // Pick new random numbers
        setRandomNumbers()
    }

    private fun setRandomNumbers() {
        val leftNum = Random.nextInt(1, 100)
        val rightNum = Random.nextInt(1, 100)
        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}
