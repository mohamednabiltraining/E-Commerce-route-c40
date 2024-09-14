package com.route.data.repositories

import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.data.dataSourcesContract.WishlistOnlineDataSource
import com.route.domain.model.Product
import com.route.domain.repositories.WishlistRepository
import javax.inject.Inject

class WishlistRepoImp @Inject constructor(
    private val onlineDataSource: WishlistOnlineDataSource
):WishlistRepository {
    override suspend fun getWishlist(): List<Product>? {
        return onlineDataSource.getWishlist()
    }
}