package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)
