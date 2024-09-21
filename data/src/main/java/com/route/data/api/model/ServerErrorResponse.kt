package com.route.data.api.model

import com.google.gson.annotations.SerializedName

data class ServerErrorResponse(

	@field:SerializedName("statusMsg")
	val statusMsg: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("errors")
	val errors: Errors? = null
)


data class Errors(

	@field:SerializedName("msg")
	val msg: String? = null,

	@field:SerializedName("param")
	val param: String? = null,

	@field:SerializedName("location")
	val location: String? = null
)
