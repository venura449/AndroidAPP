package com.example.mono

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class pass_reset_success : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pass_reset_success)

        val returnToSignInButton = findViewById<Button>(R.id.returnToSignInButton)

        returnToSignInButton.setOnClickListener {
            // Navigate back to the Sign In screen
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Optionally close the current activity
        }
    }
}
