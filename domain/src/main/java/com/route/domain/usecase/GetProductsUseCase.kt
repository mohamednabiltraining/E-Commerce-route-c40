package com.route.domain.usecase

import android.util.Log
import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import javax.inject.Inject


class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun invoke(
        categoryId: String? = null,
        brandId: String? = null,
        keyword: String? = null,
    ): List<Product>? {
        Log.e("GetProductsUseCase categoryId", categoryId.toString())
        return productsRepository.getProducts(categoryId, brandId, keyword)
    }
}