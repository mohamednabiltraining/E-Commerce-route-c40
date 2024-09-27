package com.route.domain.usecase.product

import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSpecificProductUseCase @Inject constructor(
  private  val productRepos : ProductsRepository
) {
  fun invoke( productId : String?=null):Flow<ApiResult<Product>>
    = productRepos.getSpecificProducts(productId)

}