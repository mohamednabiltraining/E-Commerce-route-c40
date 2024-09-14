package com.route.domain.repositories

import com.route.domain.model.Product


interface WishlistRepository {
    suspend fun getWishlist():List<Product>?
}