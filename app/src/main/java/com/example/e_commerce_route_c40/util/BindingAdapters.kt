package com.example.e_commerce_route_c40.util

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:showError")
fun showErrorOnTextInputLayout(
    textInputLayout: TextInputLayout,
    errorMessage:String?
){
    if(errorMessage.isNullOrBlank()){
        textInputLayout.error = null
        return
    }
    textInputLayout.error = errorMessage
}

@BindingAdapter("app:showError")
fun showErrorOnTextInputLayout(
    textInputLayout: TextInputLayout,
    @StringRes errorMessageId:Int?
){
    if(errorMessageId==null){
        textInputLayout.error = null
        return
    }
    textInputLayout.error = textInputLayout.context.getString(errorMessageId)
}