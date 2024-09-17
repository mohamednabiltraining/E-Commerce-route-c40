package com.route.data.dataSourcesContract

import com.route.domain.model.ApiResult
import com.route.domain.model.Category
import com.route.domain.model.Product
import com.route.domain.model.SubCategory
import kotlinx.coroutines.flow.Flow

interface CategoriesOnlineDataSource {
    suspend fun getProducts(
        categoryId: String? = null,
        brandId: String? = null,
        keyword: String? = null,
    ): List<Product>?

     fun getCategories(): Flow<ApiResult<List<Category>?>>
     fun getSubCategories(categoryId: String): Flow<ApiResult<List<SubCategory>?>>
}