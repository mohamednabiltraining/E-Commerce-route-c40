package com.example.e_commerce_route_c40.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.databinding.SplashBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: SplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        binding = SplashBinding.inflate(layoutInflater)

        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            // Finish the splash activity so it can't be returned to
            finish()
        }, 3000) // 3000 milliseconds delay (3 seconds)
    }

}