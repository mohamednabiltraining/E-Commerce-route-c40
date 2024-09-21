package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(

	@field:SerializedName("metadata")
	val metadata: PaginationInfo? = null,

	@field:SerializedName("data")
	val data: List<CategoryDto?>? = null,

	@field:SerializedName("results")
	val results: Int? = null,

	@field:SerializedName("data_product")
     val data_product: List<ProductDto?>? = null
)