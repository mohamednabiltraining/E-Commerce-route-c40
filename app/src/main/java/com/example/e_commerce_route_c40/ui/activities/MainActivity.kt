package com.example.e_commerce_route_c40.ui.activities

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.databinding.ActivityMainBinding
import com.example.e_commerce_route_c40.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun inflateBinding() = ActivityMainBinding.inflate(layoutInflater)
    // now you can use binding directly

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linkNavHostWithBottomNavigation()

    }

    private fun linkNavHostWithBottomNavigation() {
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavigation.setupWithNavController(navController)
    }


}