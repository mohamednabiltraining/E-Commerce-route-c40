package com.example.e_commerce_route_c40.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce_route_c40.R
import java.io.IOException
import java.net.UnknownHostException

open class BaseViewModel:ViewModel() {
    val uiMessage = MutableLiveData<UIMessage>()


    fun handleError(throwable:Throwable,
                    posActionCallBack: OnDialogClick?=null){
//        if(throwable is HttpException){
//            val errorResponse = throwable.response()?.errorBody()?.string()?.toJson(BaseResponse::class.java)
//            uiMessage.value = UIMessage(
//                showLoading = false,
//                showMessage = true,
//                message =  errorResponse?.message,
//                posButtonId = R.string.retry,
//                onPosClick = posActionCallBack
//            )
//            return
//        }
        val message = when(throwable){
            is UnknownHostException,
            is IOException ->{
                R.string.connection_error
            }
            else->{
                R.string.somethin_went_wrong
            }
        }
        uiMessage.value = UIMessage(
            showLoading = false,
            showMessage = true,
            messageId =  message,
            posButtonId = R.string.retry,
            onPosClick = posActionCallBack
        )
    }

    fun hideLoading(){
        uiMessage.value = UIMessage(
            showLoading = false
        )
    }
    fun showLoading(messageId:Int?=null,
                    message:String?=null){
        uiMessage.value = UIMessage(
            showLoading = true,
            messageId = messageId,
            message = message
        )
    }

}