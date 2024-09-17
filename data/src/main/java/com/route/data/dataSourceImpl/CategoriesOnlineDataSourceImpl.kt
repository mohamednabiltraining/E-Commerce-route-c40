package com.route.data.dataSourceImpl

import android.util.Log
import com.route.data.api.WebServices
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.data.executeApi
import com.route.domain.model.ApiResult
import com.route.domain.model.Category
import com.route.domain.model.Product
import com.route.domain.model.SubCategory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoriesOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) :CategoriesOnlineDataSource {

    override fun getCategories(): Flow<ApiResult<List<Category>?>> {
        return executeApi {
            webServices.getCategories()
                .data?.map {categoryDto ->
                    categoryDto?.toCategory() ?: Category()
                }
        }
    }

    override fun getSubCategories(categoryId: String): Flow<ApiResult<List<SubCategory>?>> {
        return executeApi {
            webServices.getSubCategories(categoryId)
                .data?.map {categoryDto->
                    categoryDto?.toSubCategory() ?: SubCategory()
                }
        }
    }

    override suspend fun getProducts(
        categoryId: String?,
        brandId: String?,
        keyword: String?,
    ): List<Product>? {
        val response = webServices.getProducts(categoryId, brandId, keyword)
        Log.e("CategoriesOnlineDataSourceImpl categoryId", categoryId.toString())
        return response.data?.map { productDto ->
            productDto?.toProduct() ?: Product()
        }
    }
}