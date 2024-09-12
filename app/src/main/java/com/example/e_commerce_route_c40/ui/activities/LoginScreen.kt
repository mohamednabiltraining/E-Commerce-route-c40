package com.example.e_commerce_route_c40.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.LoginPageBinding

class LoginScreen : BaseFragment<LoginPageBinding, LoginViewModel>() {

    private val loginViewModel : LoginViewModel by viewModels()

    override fun getLayoutId(): Int {
        return R.layout.login_page
    }

    override fun initViewModel(): LoginViewModel {
        return loginViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.createAcc.setOnClickListener {
            createAccount()
        }

        binding.buttonLogin.setOnClickListener {
            logIntoAccount()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        loginViewModel.GetLogin("","")
    }

    private fun observeLiveData() {
        loginViewModel.loginLiveData.observe(viewLifecycleOwner) { loginResult ->
            loginResult?.let {
                if (loginResult != null) {
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun logIntoAccount() {
        if (isValidate())
            Toast.makeText(activity, "login successfully", Toast.LENGTH_SHORT).show()
    }

    private fun createAccount() {
        val action = LoginScreenDirections.actionLoginScreenToHomeFragment()
        findNavController(this).navigate(action)
    }

    private fun isValidate(): Boolean {
        var isValid = true

        // Regex patterns
        val usernameRegex = "^[a-zA-Z0-9._]{3,15}$".toRegex()
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()

        // Validate Username
        val username = binding.inputUserNameOrEmail.editText?.text.toString()
        if (username.isBlank()) {
            isValid = false
            binding.inputUserNameOrEmail.error = "Please enter your name or email"
            binding.inputUserNameOrEmail.editText?.requestFocus()
        } else if (!username.matches(usernameRegex) && !username.matches(emailRegex)) {
            isValid = false
            binding.inputUserNameOrEmail.error =
                "Username must be 3-15 characters long and can contain letters, digits, underscores, and periods."
            binding.inputUserNameOrEmail.editText?.requestFocus()
        } else {
            binding.inputUserNameOrEmail.error = null
        }

        // Validate Password
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