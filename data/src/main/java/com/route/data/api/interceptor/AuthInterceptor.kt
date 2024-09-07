package com.route.data.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor :Interceptor {

    val apiKey = "5909ae28122a471d8b0c237d5989cb73"
    val AUTH_HEADER = "Authorization"
    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        newBuilder.header(AUTH_HEADER,apiKey)
        return chain.proceed(newBuilder.build())
    }
}