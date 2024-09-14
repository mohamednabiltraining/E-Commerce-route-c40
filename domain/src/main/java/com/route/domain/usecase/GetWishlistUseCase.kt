package com.route.domain.usecase


import com.route.domain.model.Product
import com.route.domain.repositories.WishlistRepository
import javax.inject.Inject

class GetWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    suspend fun invoke():List<Product>? {
        return wishlistRepository.getWishlist()
    }
}