package com.example.mono
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

        val resetPasswordButton = findViewById<Button>(R.id.continueButton)

        resetPasswordButton.setOnClickListener {
            val intent = Intent(this, pass_reset_success::class.java)
            startActivity(intent)
        }
    }
}
