package com.example.loginprofileapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREFS_NAME = "com.example.loginprofileapp.PREFS"
        const val KEY_USERNAME = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // If a username was saved on a previous run, pre-fill it —
        // proof that this data survived even though the app was closed.
        val savedUsername = prefs.getString(KEY_USERNAME, null)
        if (savedUsername != null) {
            usernameInput.setText(savedUsername)
        }

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()

            // Save the value under a key, independent of any Intent.
            // apply() writes it asynchronously in the background.
            prefs.edit().putString(KEY_USERNAME, username).apply()

            // Notice: no putExtra() here at all — ProfileActivity will
            // read this same SharedPreferences file on its own.
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}
