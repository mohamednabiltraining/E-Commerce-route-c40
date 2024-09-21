package com.route.data.dataSourcesContract

import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface WishlistOnlineDataSource {

     fun getWishlist(): Flow<ApiResult<List<Product>?>>
}