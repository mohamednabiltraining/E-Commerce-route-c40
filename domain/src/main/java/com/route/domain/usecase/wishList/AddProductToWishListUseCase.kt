package com.route.domain.usecase.wishList


import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.repositories.WishlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddProductToWishListUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    fun invoke(product: Product): Flow<ApiResult<List<String>?>> {
        return wishlistRepository.addToWishList(product.id)
    }
}