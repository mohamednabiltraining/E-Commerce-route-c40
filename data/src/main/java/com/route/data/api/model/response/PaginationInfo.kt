package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName

data class PaginationInfo(

	@field:SerializedName("numberOfPages")
	val numberOfPages: Int? = null,

	@field:SerializedName("nextPage")
	val nextPage: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("prevPage")
	val prevPage: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null
)