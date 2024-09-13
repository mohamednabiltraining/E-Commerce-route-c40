package com.route.domain.repositories

import com.route.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(
        categoryId: String? = null,
        brandId: String? = null,
        subCategoryId: String? = null,
        keyword: String? = null,
    ): List<Product>?
}