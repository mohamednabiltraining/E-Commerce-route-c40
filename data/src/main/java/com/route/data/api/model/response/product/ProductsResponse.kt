package com.route.data.api.model.response.product

import com.google.gson.annotations.SerializedName
import com.route.data.api.model.response.bases.PaginationInfo

data class ProductsResponse(
    @field:SerializedName("metadata")
    val metadata: PaginationInfo? = null,

    @field:SerializedName("data")
    val data: List<ProductDto?>? = null,

    @field:SerializedName("results")
    val results: Int? = null
)
