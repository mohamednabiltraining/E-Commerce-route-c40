package com.route.data.repositories

import android.util.Log
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val onlineDataSource: CategoriesOnlineDataSource
) : ProductsRepository {
    override suspend fun getProducts(
        categoryId: String?,
        brandId: String?,
        keyword: String?,
    ): List<Product>? {
        Log.e("ProductsRepositoryImpl categoryId", categoryId.toString())
        return onlineDataSource.getProducts(categoryId, brandId, keyword)
    }
}