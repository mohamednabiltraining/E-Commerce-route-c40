package com.example.e_commerce_route_c40.ui.activities

import android.os.Bundle
import android.widget.Toast
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseActivity
import com.example.e_commerce_route_c40.databinding.CreateAccountActivityBinding

class CreateAccount : BaseActivity<CreateAccountActivityBinding>() {

    override fun getLayoutId(): Int = R.layout.create_account_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.buttonSignup.setOnClickListener {
            signUpToAccount()
        }
    }

    private fun signUpToAccount() {
        if (isValidate())
            Toast.makeText(this, "sign up to account successful", Toast.LENGTH_SHORT).show()
    }

    private fun isValidate(): Boolean {

        var isValid = true

        // Regex patterns
        val usernameRegex = "^[a-zA-Z0-9._]{3,15}$".toRegex()
        val passwordRegex =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}$".toRegex()
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()
        val phoneRegex = "^\\d{11}$".toRegex()

        val userName = binding.userFullName.editText?.text.toString()
        if (userName.isBlank()) {
            isValid = false
            binding.userFullName.error = "please enter your full name"
            binding.userFullName.editText?.requestFocus()
        } else if (!userName.matches(usernameRegex)) {
            binding.userFullName.error =
                "Username must be 3-15 characters long and can contain letters, digits, underscores, and periods."
            binding.userFullName.editText?.requestFocus()
        } else {
            binding.userFullName.error = null
        }

        val userPassword = binding.inputUserPass.editText?.text.toString()
        if (userPassword.isBlank()) {
            isValid = false
            binding.inputUserPass.error = "please enter your password"
            binding.inputUserPass.editText?.requestFocus()
        } else if (!userPassword.matches(passwordRegex)) {
            binding.inputUserPass.error =
                "Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character."
            binding.inputUserPass.editText?.requestFocus()
        } else {
            binding.inputUserPass.error = null
        }

        val userEmail = binding.inputEmailAddress.editText?.text.toString()
        if (userEmail.isBlank()) {
            isValid = false
            binding.inputEmailAddress.error = "please enter your email"
            binding.inputEmailAddress.editText?.requestFocus()
        } else if (!userEmail.matches(emailRegex)) {
            binding.inputEmailAddress.error = "Invalid email format"
            binding.inputEmailAddress.editText?.requestFocus()
        } else {
            binding.inputEmailAddress.error = null
        }

        val userPhone = binding.inputUserMobile.editText?.text.toString()
        if (userPhone.isBlank()) {
            isValid = false
            binding.inputUserMobile.error = "please enter your phone number"
            binding.inputUserMobile.editText?.requestFocus()
        } else if (!userPhone.matches(phoneRegex)) {
            binding.inputUserMobile.error = "Invalid phone number format"
            binding.inputUserMobile.editText?.requestFocus()
        } else {
            binding.inputUserMobile.error = null
        }
        return isValid
    }

}