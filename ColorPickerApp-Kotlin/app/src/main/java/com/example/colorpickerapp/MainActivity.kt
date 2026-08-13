package com.example.colorpickerapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SELECTED_COLOR = "com.example.colorpickerapp.EXTRA_SELECTED_COLOR"
    }

    private lateinit var resultText: TextView

    // This is the modern replacement for the old startActivityForResult()/
    // onActivityResult() pair. The launcher knows how to start SecondActivity
    // and will run the lambda below automatically once it finishes and sends
    // a result back — no manual requestCode bookkeeping needed.
    private val pickColorLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val colorName = result.data?.getStringExtra(EXTRA_SELECTED_COLOR) ?: "Unknown"
            resultText.text = "You picked: $colorName"
            resultText.setBackgroundColor(colorFor(colorName))
        } else {
            resultText.text = "No color selected (cancelled)."
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)
        val pickButton = findViewById<Button>(R.id.pickButton)

        pickButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            pickColorLauncher.launch(intent)
        }
    }

    private fun colorFor(name: String): Int = when (name) {
        "Red" -> Color.parseColor("#F44336")
        "Green" -> Color.parseColor("#4CAF50")
        "Blue" -> Color.parseColor("#2196F3")
        "Yellow" -> Color.parseColor("#FBC02D")
        else -> Color.LTGRAY
    }
}
