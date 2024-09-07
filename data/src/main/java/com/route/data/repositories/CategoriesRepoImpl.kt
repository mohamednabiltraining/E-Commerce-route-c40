package com.route.data.repositories

import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.domain.model.Category
import com.route.domain.model.SubCategory
import com.route.domain.repositories.CategoriesRepository
import javax.inject.Inject

class CategoriesRepoImpl @Inject constructor(
    private val onlineDataSource: CategoriesOnlineDataSource
):CategoriesRepository {

    override suspend fun getCategories(): List<Category>? {
        return onlineDataSource.getCategories()
    }

    override suspend fun getSubCategories(categoryId: String): List<SubCategory>? {
        return onlineDataSource.getSubCategories(categoryId)
    }
}