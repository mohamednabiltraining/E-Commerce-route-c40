package com.route.data.dataSourceImpl

import android.util.Log
import com.route.data.api.WebServices
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.domain.model.Category
import com.route.domain.model.Product
import com.route.domain.model.SubCategory
import javax.inject.Inject

class CategoriesOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) :CategoriesOnlineDataSource {

    override suspend fun getCategories(): List<Category>? {
        val response = webServices.getCategories()
        return response.data?.map {categoryDto ->
            categoryDto?.toCategory() ?: Category()
        }
    }

    override suspend fun getSubCategories(categoryId: String): List<SubCategory>? {
        val response = webServices.getSubCategories(categoryId)
        return response.data?.map {categoryDto ->
            categoryDto?.toSubCategory() ?: SubCategory()
        }
    }

    override suspend fun getProducts(
        categoryId: String?,
        brandId: String?,
        keyword: String?,
    ): List<Product>? {
        val response = webServices.getProducts(categoryId, brandId, keyword)
        Log.e("CategoriesOnlineDataSourceImpl categoryId", categoryId.toString())
        return response.data?.map { ProductDto ->
            ProductDto?.toProduct() ?: Product()
        }
    }
}