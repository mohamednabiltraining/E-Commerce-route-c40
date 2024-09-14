package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.dataSourcesContract.WishlistOnlineDataSource
import com.route.domain.model.Product
import javax.inject.Inject

class WishlistOnlineDataSourceImp @Inject constructor(
    private val webServices: WebServices
) : WishlistOnlineDataSource {
    override suspend fun getWishlist(): List<Product>? {
        val response = webServices.getWishlist()
        return response.data_product?.map {productDto ->
            productDto?.toProduct() ?: Product()
        }
    }

}