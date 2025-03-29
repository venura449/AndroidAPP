package com.example.mono
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2



class OnboardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        viewPager = findViewById(R.id.viewPager)

        val adapter = OnboardingAdapter()
        viewPager.adapter = adapter

        findViewById<Button>(R.id.btnSkip).setOnClickListener {
            navigateToHome()
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.currentItem += 1
            } else {
                navigateToHome()
            }
        }
    }

    private fun navigateToHome() {
        sharedPreferences.edit().putBoolean("FirstTime", false).apply()
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
}
