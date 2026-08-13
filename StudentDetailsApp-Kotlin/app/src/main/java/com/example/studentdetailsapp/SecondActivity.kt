package com.example.studentdetailsapp

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val detailsText = findViewById<TextView>(R.id.detailsText)
        val backButton = findViewById<Button>(R.id.backButton)

        // getParcelableExtra(String) without a class argument was
        // deprecated in Android 13 (Tiramisu) in favor of a type-safe
        // overload. This check lets the same code run correctly on
        // both older and newer devices, since our minSdk (26) is
        // below API 33.
        val student: Student? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_STUDENT, Student::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(MainActivity.EXTRA_STUDENT)
        }

        detailsText.text = if (student != null) {
            "Name: ${student.name}\nRoll Number: ${student.rollNumber}\nMarks: ${student.marks}"
        } else {
            "No student data received."
        }

        backButton.setOnClickListener { finish() }
    }
}
