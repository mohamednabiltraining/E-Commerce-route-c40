package com.route.domain.repositories

import com.route.domain.model.Category
import com.route.domain.model.SubCategory

interface CategoriesRepository {
    suspend fun getCategories():List<Category>?
    suspend fun getSubCategories(categoryId:String):List<SubCategory>?
}