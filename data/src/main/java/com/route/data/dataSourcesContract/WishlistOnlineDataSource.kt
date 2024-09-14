package com.route.data.dataSourcesContract

import com.route.domain.model.Product

interface WishlistOnlineDataSource {

    suspend fun getWishlist():List<Product>?
}