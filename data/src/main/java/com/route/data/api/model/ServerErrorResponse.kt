package com.route.data.api.model

import com.google.gson.annotations.SerializedName

data class ServerErrorResponse(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null
)
