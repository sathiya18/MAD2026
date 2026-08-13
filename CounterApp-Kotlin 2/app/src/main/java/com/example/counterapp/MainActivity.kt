package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Counter variable — Kotlin infers the type (Int) automatically
    private var count = 0

    private lateinit var countText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their XML id
        countText = findViewById(R.id.countText)
        val incrementButton: Button = findViewById(R.id.incrementButton)
        val resetButton: Button = findViewById(R.id.resetButton)

        // Click listener written as a lambda — no "new" keyword needed
        incrementButton.setOnClickListener {
            count++
            updateText()
        }

        resetButton.setOnClickListener {
            count = 0
            updateText()
        }
    }

    private fun updateText() {
        countText.text = "Count: $count"
    }
}
