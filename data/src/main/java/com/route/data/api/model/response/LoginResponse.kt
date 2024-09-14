package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.LoginData

data class LoginResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("token")
	val token: String? = null
) {
	fun toLoginData(): LoginData {
		return LoginData(
			email = user?.email,
			name = user?.name,
			token = token
		)
	}
}