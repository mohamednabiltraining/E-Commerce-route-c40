package com.example.e_commerce_route_c40.ui.activities

import androidx.lifecycle.MutableLiveData
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.example.e_commerce_route_c40.util.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateAccountViewModel @Inject constructor():BaseViewModel() {

    val emailLiveData = MutableLiveData<String>()
    val passwordLiveData = MutableLiveData<String>()
    val userNameLiveData = MutableLiveData<String>()
    val mobileNumLiveData = MutableLiveData<String>()

    val emailError = MutableLiveData<Int?>()
    val passwordError = MutableLiveData<Int?>()
    val userNameError = MutableLiveData<Int?>()
    val mobileNumError = MutableLiveData<Int?>()

    fun onSignUpClick(){
        if(!isValidaForm()){
            return
        }
        signUp(email = emailLiveData.value!!,
            password = passwordLiveData.value!!,
            userName = userNameLiveData.value!!,
            mobileNum = mobileNumLiveData.value!!)
    }

    private fun signUp(email: String, password: String, userName: String, mobileNum: String){

    }

    private fun isValidaForm(): Boolean {
        var isValid = true
        if (emailLiveData.value.isNullOrEmpty()) {
            isValid = false
            emailError.value = R.string.please_enter_your_email
        } else if (!ValidationUtils.isValidEmail(email = emailLiveData.value)){
            isValid = false
            emailError.value = R.string.email_format_not_valid
        } else {
            emailError.value = null
        }

        if (passwordLiveData.value.isNullOrEmpty()) {
            isValid = false
            passwordError.value = R.string.please_enter_your_password
        } else if (!ValidationUtils.isValidPassword(password = passwordLiveData.value)) {
            isValid = false
            passwordError.value = R.string.please_enter_valid_password
        } else {
            passwordError.value = null
        }

        if (userNameLiveData.value.isNullOrEmpty()) {
            isValid = false
            userNameError.value = R.string.please_enter_your_name
        }else if (!ValidationUtils.isValidUserName(username = userNameLiveData.value!!)) {
            isValid = false
            mobileNumError.value = R.string.please_enter_valid_name
        } else {
            userNameError.value = null
        }

        if (mobileNumLiveData.value.isNullOrEmpty()) {
            isValid = false
            mobileNumError.value = R.string.please_enter_your_mobile_number
        } else if (!ValidationUtils.isValidMobileNumber(mobileNum = mobileNumLiveData.value!!)) {
            isValid = false
            mobileNumError.value = R.string.please_enter_valid_mobile_number
        } else {
            mobileNumError.value = null
        }
        return isValid
    }

}