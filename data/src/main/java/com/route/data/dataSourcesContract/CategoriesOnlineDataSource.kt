package com.route.data.dataSourcesContract

import com.route.domain.model.Category
import com.route.domain.model.Product
import com.route.domain.model.SubCategory

interface CategoriesOnlineDataSource {
    suspend fun getCategories():List<Category>?
    suspend fun getSubCategories(categoryId: String): List<SubCategory>?
    suspend fun getProducts(
        categoryId: String? = null,
        brandId: String? = null,
        keyword: String? = null,
    ): List<Product>?

}