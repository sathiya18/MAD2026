package com.example.datatransferapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        // Key used to label the data inside the Intent's extras bundle.
        // Using the package name as a prefix avoids clashing with keys
        // from other apps or other extras in the same Intent.
        const val EXTRA_NAME = "com.example.datatransferapp.EXTRA_NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val name = nameInput.text.toString()

            // 1. Create an Intent that targets SecondActivity.
            val intent = Intent(this, SecondActivity::class.java)

            // 2. Attach the data as an "extra" — a key/value pair
            //    stored inside the Intent's Bundle.
            intent.putExtra(EXTRA_NAME, name)

            // 3. Start SecondActivity; Android delivers the Intent
            //    (and its extras) to it automatically.
            startActivity(intent)
        }
    }
}
