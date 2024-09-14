package com.route.domain.model


sealed interface ApiResult<T> {

    data class Success<T>(val data:T,
        val message:String? = null ) : ApiResult<T>

    data class Failure<T>(
        val throwable: Throwable
    ):ApiResult<T>

    data class Loading<T>(val isLoading:Boolean = true):ApiResult<T>

}