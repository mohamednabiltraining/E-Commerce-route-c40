package com.route.data.api.model.response.Auth

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)