package com.route.domain.repositories

import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import kotlinx.coroutines.flow.Flow


interface WishlistRepository {
    fun getWishlist(): Flow<ApiResult<List<Product>?>>
}