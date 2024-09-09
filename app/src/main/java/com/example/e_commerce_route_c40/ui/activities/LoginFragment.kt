package com.example.e_commerce_route_c40.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentLoginBinding
import com.example.e_commerce_route_c40.util.hideBottomAppBarViews

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.fragment_login
    }

    override fun initViewModel(): LoginViewModel {
        return loginViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideBottomAppBarViews()

        binding.createAcc.setOnClickListener {
            createAccount()
        }

        binding.buttonLogin.setOnClickListener {
            logIntoAccount()
        }
    }

    private fun logIntoAccount() {
        if (isValidate()) {
            val email = binding.inputUserName.editText?.text.toString()
            val password = binding.inputUserPass.editText?.text.toString()

            loginViewModel.getLoginData(email,password)

            loginViewModel.loginLiveData.observe(viewLifecycleOwner){ loginData ->
                if (loginData != null){
                    Toast.makeText(activity, "Login successful: Welcome ${loginData.email}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Login failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun createAccount() {
        val intent = Intent(activity, CreateAccount::class.java)
        startActivity(intent)
    }

    private fun isValidate(): Boolean {
        var isValid = true

        val usernameRegex = "^[a-zA-Z0-9._]{3,15}$".toRegex()
        val passwordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()

        val username = binding.inputUserName.editText?.text.toString()
        if (username.isBlank()) {
            isValid = false
            binding.inputUserName.error = "Please enter your name"
            binding.inputUserName.editText?.requestFocus()
        } else if (!username.matches(usernameRegex)) {
            isValid = false
            binding.inputUserName.error =
                "Username must be 3-15 characters long and can contain letters, digits, underscores, and periods."
            binding.inputUserName.editText?.requestFocus()
        } else {
            binding.inputUserName.error = null
        }

        val password = binding.inputUserPass.editText?.text.toString()
        if (password.isBlank()) {
            isValid = false
            binding.inputUserPass.error = "Please enter your password"
            binding.inputUserPass.editText?.requestFocus()
        } else if (!password.matches(passwordRegex)) {
            isValid = false
            binding.inputUserPass.error =
                "Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character."
            binding.inputUserPass.editText?.requestFocus()
        } else {
            binding.inputUserPass.error = null
        }

        return isValid
    }

}