package com.route.data.api

import com.route.data.api.model.response.CategoriesResponse
import com.route.data.api.model.response.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WebServices {

    @GET("api/v1/categories")
    suspend fun getCategories():CategoriesResponse

    @GET("api/v1/categories/{catId}/subcategories")
    suspend fun getSubCategories(
        @Path("catId")categoryId:String
    ):CategoriesResponse

    @GET("api/v1/products")
    suspend fun getProducts(
        @Query("catId") categoryId: String? = null,
        @Query("brand") brandId: String? = null,
        @Query("subCatId") subCategoryId: String? = null,
        @Query("keyword") keyword: String? = null,
    ): ProductsResponse


}