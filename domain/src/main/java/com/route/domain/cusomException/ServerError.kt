package com.route.domain.cusomException

class ServerError (
    val statusMsg:String ?= null,
    val serverMessage:String? = null) : Throwable(serverMessage) {


}