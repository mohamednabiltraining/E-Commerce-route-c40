package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.AuthData

data class SignUpResponse(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("token")
	val token: String? = null,

){
	fun toSignUpData(): AuthData {
		return AuthData(
			email = user?.email,
			name = user?.name,
			token = token
		)
	}
}