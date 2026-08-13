package com.example.studentdetailsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STUDENT = "com.example.studentdetailsapp.EXTRA_STUDENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val rollInput = findViewById<EditText>(R.id.rollInput)
        val marksInput = findViewById<EditText>(R.id.marksInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val roll = rollInput.text.toString()
            val marks = marksInput.text.toString().toIntOrNull() ?: 0

            // Package all three fields into ONE Parcelable object,
            // instead of three separate putExtra() calls.
            val student = Student(name, roll, marks)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_STUDENT, student)
            startActivity(intent)
        }
    }
}
