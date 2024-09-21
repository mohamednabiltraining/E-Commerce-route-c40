package com.route.domain.usecase


import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.repositories.WishlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    suspend fun invoke(): Flow<ApiResult<List<Product>?>> {
        return wishlistRepository.getWishlist()
    }
}