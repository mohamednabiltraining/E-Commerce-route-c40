package com.example.e_commerce_route_c40.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_route_c40.R
import com.route.domain.cusomException.ConnectionError
import com.route.domain.cusomException.ServerError
import com.route.domain.model.ApiResult
import java.io.IOException
import java.net.UnknownHostException

open class BaseViewModel:ViewModel() {
    val uiMessage = MutableLiveData<UIMessage>()


    fun handleError(throwable:Throwable,
                    posActionCallBack: OnDialogClick?=null){
        if(throwable is ServerError){

            uiMessage.postValue(
                UIMessage(
                showLoading = false,
                showMessage = true,
                message =  throwable.serverMessage,
                posButtonId = R.string.retry,
                onPosClick = posActionCallBack
            )
            )
            return
        }

        val message = when(throwable){
            is ConnectionError ->{
                R.string.connection_error
            }
            else->{
                R.string.somethin_went_wrong
            }
        }
        uiMessage.postValue( UIMessage(
            showLoading = false,
            showMessage = true,
            messageId =  message,
            posButtonId = R.string.retry,
            onPosClick = posActionCallBack
        ))
    }

    fun hideLoading(){
        uiMessage.postValue(
            UIMessage(
            showLoading = false)
        )
    }
    fun showLoading(messageId:Int?=null,
                    message:String?=null){
        uiMessage.postValue(UIMessage(
            showLoading = true,
            messageId = messageId,
            message = message
        ))
    }
    fun handleLoading(loading:ApiResult.Loading<*>){
        if(loading.isLoading){
            showLoading(R.string.loading)
            return
        }
        hideLoading()

    }

}