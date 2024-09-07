package com.route.data.dataSourcesContract

import com.route.domain.model.Category
import com.route.domain.model.SubCategory

interface CategoriesOnlineDataSource {
    suspend fun getCategories():List<Category>?
    suspend fun getSubCategories(categoryId: String): List<SubCategory>?
}