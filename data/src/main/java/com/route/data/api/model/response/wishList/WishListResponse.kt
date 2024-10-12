package com.route.data.api.model.response.wishList

import com.google.gson.annotations.SerializedName
import com.route.data.api.model.response.bases.PaginationInfo
import com.route.data.api.model.response.product.ProductDto

data class WishListResponse(

    @field:SerializedName("metadata")
	val metadata: PaginationInfo? = null,

    @field:SerializedName("data")
	val data: List<ProductDto?>? = null,

    @field:SerializedName("results")
	val results: Int? = null,
)