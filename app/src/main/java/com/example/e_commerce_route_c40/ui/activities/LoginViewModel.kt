package com.example.e_commerce_route_c40.ui.activities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.LoginData
import com.route.domain.usecase.GetLoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase
): BaseViewModel() {

    val loginLiveData = MutableLiveData<LoginData>()

    fun getLoginData(email : String, password : String){
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val login = getLoginUseCase.invoke(email, password)
                loginLiveData.postValue(login)
            }
        } catch (e: Exception){
            handleError(e)
        }
    }
}