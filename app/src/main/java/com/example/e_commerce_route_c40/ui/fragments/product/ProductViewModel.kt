package com.example.e_commerce_route_c40.ui.fragments.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.model.SubCategory
import com.route.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsUseCase: GetProductsUseCase,
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel() {

    val productsLiveData = MutableLiveData<List<Product>?>()

    private val subCategory: SubCategory? = savedStateHandle["subCategory"]
    fun getProductsByCategory() {
        runBlocking {
            productsUseCase.invoke() //categoryId = subCategory?.id
                .collect { res ->
                    when (res) {
                        is ApiResult.Failure -> handleError(res.throwable)
                        is ApiResult.Loading -> handleLoading(res)
                        is ApiResult.Success -> productsLiveData.postValue(res.data)
                    }


                }
        }

    }

    fun getProductsByKey(key: String) {
        runBlocking {
            productsUseCase.invoke(keyword = key)
                .collect { res ->
                    when (res) {
                        is ApiResult.Failure -> handleError(res.throwable)
                        is ApiResult.Loading -> handleLoading(res)
                        is ApiResult.Success -> productsLiveData.postValue(res.data)
                    }
                }
        }
    }
}