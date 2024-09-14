package com.example.e_commerce_route_c40.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.LoginPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreen : BaseFragment<LoginPageBinding, LoginViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.login_page
    }

    private val _viewModel: LoginViewModel by viewModels ()

    override fun initViewModel(): LoginViewModel {
        return _viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.createAcc.setOnClickListener {
            createAccount()
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        _viewModel.loginLiveData.observe(viewLifecycleOwner) { loginResult ->
            loginResult?.let {
                if (loginResult != null) {
                    navigateToHome()
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(
            R.id.action_loginScreen_to_homeFragment
        )
    }

    private fun createAccount() {
        val action = LoginScreenDirections.actionLoginScreenToHomeFragment()
        findNavController(this).navigate(action)
    }


}