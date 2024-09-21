package com.route.data.api.model.request

import com.google.gson.annotations.SerializedName

data class AddWishListRequest(

	@field:SerializedName("productId")
	val productId: String? = null
)
