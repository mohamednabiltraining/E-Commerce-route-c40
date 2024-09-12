package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.LoginData

data class LoginRequest(

    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String
) {
    fun toLoginData(): LoginData {
        return LoginData(
            email = email,
            password = password
        )
    }
}