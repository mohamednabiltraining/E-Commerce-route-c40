package com.route.data.repositories

import android.util.Log
import com.route.data.dataSourcesContract.ProductsOnlineDataSource
import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val onlineDataSource: ProductsOnlineDataSource
) : ProductsRepository {
    override  fun getProducts(
        categoryId: String?,
        brandId: String?,
        keyword: String?,
    ): Flow<ApiResult<List<Product>?>> {
        Log.e("ProductsRepositoryImpl categoryId", categoryId.toString())
        return onlineDataSource.getProducts(categoryId, brandId, keyword)
    }

    override  fun getSpecificProducts(productId: String?): Flow<ApiResult<Product>>{
        return onlineDataSource.getSpecificProduct(productId)

    }


}