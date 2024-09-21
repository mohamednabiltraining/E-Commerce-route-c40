package com.route.data.api

import com.route.data.api.model.response.CategoriesResponse

import com.route.data.api.model.response.LoginRequest
import com.route.data.api.model.response.LoginResponse
import com.route.data.api.model.response.ProductsResponse
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
        @Query("category") categoryId: String? = null,
        @Query("brand") brandId: String? = null,
        @Query("keyword") keyword: String? = null,
    ): ProductsResponse

    @POST("api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): LoginResponse


    @POST("api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    ): SignUpResponse

    @GET("api/v1/wishlist")
    suspend fun getWishlist():CategoriesResponse

}