package com.route.data.dataSourcesContract

import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsOnlineDataSource {
     fun getProducts(
        categoryId: String? = null,
        brandId: String? = null,
        keyword: String? = null,
    ): Flow<ApiResult<List<Product>?>>

     fun getSpecificProduct(productId:String?=null
    ):Flow<ApiResult<Product>>

}