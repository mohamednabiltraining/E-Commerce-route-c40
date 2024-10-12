package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.dataSourcesContract.ProductsOnlineDataSource
import com.route.data.executeApi
import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductsOnlineDataSource {

    override  fun getProducts(
        categoryId: String?,
        brandId: String?,
        keyword: String?
    ): Flow<ApiResult<List<Product>?>> {
        return executeApi {
            val response = webServices.getProducts(categoryId, brandId, keyword)
            response.data?.map { productDto ->
                productDto?.toProduct() ?: Product()
            }}

        }

    override  fun getSpecificProduct(productId: String?):Flow<ApiResult<Product>>  {

            return executeApi {
                val response =  webServices.getSpecificProduct(productId)
                response.data?.toProduct()?:Product()
            }
            }

}

