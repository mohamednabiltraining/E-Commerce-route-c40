package com.example.e_commerce_route_c40.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.example.e_commerce_route_c40.databinding.SplashBinding

class SplashScreen : BaseFragment<SplashBinding,BaseViewModel>() {
    private val _viewModel:BaseViewModel by viewModels()
    override fun initViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.splash
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper())
            .postDelayed({
                navigateToHome()
            },2000)
    }

    private fun navigateToHome() {
        findNavController()
            .navigate(R.id.action_global_to_login_screen)
    }

}