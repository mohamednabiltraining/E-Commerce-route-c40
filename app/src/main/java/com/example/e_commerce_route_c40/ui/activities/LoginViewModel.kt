package com.example.e_commerce_route_c40.ui.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.LoginData
import com.route.domain.usecase.GetLoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: GetLoginUseCase
): BaseViewModel() {
    private val _loginLiveData = MutableLiveData<List<LoginData>?>()
    val loginLiveData: LiveData<List<LoginData>?> = _loginLiveData

    fun GetLogin(email: String, password: String){
        try {
            viewModelScope.launch (Dispatchers.IO){
                val login = loginUseCase.invoke(email, password)
                _loginLiveData.postValue(login)
            }
            }catch (e:Exception){
            handleError(e)
        }
    }
}