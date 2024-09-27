package com.route.data.api.model.response.category

import com.google.gson.annotations.SerializedName
import com.route.data.api.model.response.bases.PaginationInfo

data class CategoriesResponse(

    @field:SerializedName("metadata")
	val metadata: PaginationInfo? = null,

    @field:SerializedName("data")
	val data: List<CategoryDto?>? = null,

    @field:SerializedName("results")
	val results: Int? = null,
)