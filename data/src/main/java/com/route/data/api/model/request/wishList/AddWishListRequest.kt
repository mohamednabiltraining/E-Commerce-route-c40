package com.route.data.api.model.request.wishList

import com.google.gson.annotations.SerializedName

data class AddWishListRequest(

	@field:SerializedName("productId")
	val productId: String? = null
)
