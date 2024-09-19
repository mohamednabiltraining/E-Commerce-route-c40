package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.SignUpData

data class SignUpResponse(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("signUpResponse")
	val signUpRequest: SignUpRequest? = null,
){
	fun toSignUpData(): SignUpData {
		return SignUpData(
			email = signUpRequest?.email,
			name = signUpRequest?.name,
			phone = signUpRequest?.phone,
			password = signUpRequest?.password
		)
	}
}