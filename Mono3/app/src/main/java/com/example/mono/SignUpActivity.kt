package com.example.mono

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val emailInput = findViewById<EditText>(R.id.emailInputSignUp)
        val passwordInput = findViewById<EditText>(R.id.passwordInputSignUp)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val signInText = findViewById<TextView>(R.id.signInText)

        signUpButton.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val isTermsAccepted = termsCheckBox.isChecked

            if (username.isEmpty()) {
                usernameInput.error = "Username cannot be empty"
                return@setOnClickListener
            }

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "Enter a valid email address"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordInput.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            if (!isTermsAccepted) {
                Toast.makeText(this, "You must accept the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // If all validations pass
            Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        signInText.setOnClickListener {
            Toast.makeText(this, "Navigating to Sign In", Toast.LENGTH_SHORT).show()
            val intent1 = Intent(this, SignInActivity::class.java)
            startActivity(intent1)
            finish()
        }
    }
}
