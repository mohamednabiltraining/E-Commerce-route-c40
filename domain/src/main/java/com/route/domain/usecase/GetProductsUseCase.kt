package com.route.domain.usecase

import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import javax.inject.Inject


class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun invoke(
        categoryId: String? = null,
        brandId: String? = null,
        subCategoryId: String? = null,
        keyword: String? = null,
    ): List<Product>? {
        return productsRepository.getProducts(categoryId, brandId, subCategoryId, keyword)
    }
}