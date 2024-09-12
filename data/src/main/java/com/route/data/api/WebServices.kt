package com.route.data.api

import com.route.data.api.model.response.CategoriesResponse
import com.route.data.api.model.response.UserLogin
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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
        @Query("catId")categoryId:String? =null,
    ):CategoriesResponse

    @POST("api/v1/auth/signin")
    suspend fun login(
        @Body email: String,
        @Body password: String
    ):UserLogin
}