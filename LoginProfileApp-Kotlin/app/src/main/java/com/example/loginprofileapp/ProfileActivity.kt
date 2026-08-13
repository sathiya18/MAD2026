package com.example.loginprofileapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Reads from the SAME SharedPreferences file MainActivity wrote to —
        // this activity was never given the username directly.
        val prefs: SharedPreferences =
            getSharedPreferences(MainActivity.PREFS_NAME, Context.MODE_PRIVATE)
        val username = prefs.getString(MainActivity.KEY_USERNAME, "Guest")

        welcomeText.text = "Welcome, $username!\n\nClose this app completely and reopen it — " +
            "this username will still be here, because it's stored in SharedPreferences, " +
            "not passed through an Intent."

        logoutButton.setOnClickListener {
            prefs.edit().clear().apply()
            finish()
        }
    }
}
