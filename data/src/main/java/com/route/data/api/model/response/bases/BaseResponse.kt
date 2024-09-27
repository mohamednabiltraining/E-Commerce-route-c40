package com.route.data.api.model.response.bases

import com.google.gson.annotations.SerializedName
import com.route.data.api.model.Errors

data class BaseResponse<T>(

	@field:SerializedName("data")
	val data:T? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("errors")
	val errors: Errors? = null

)
