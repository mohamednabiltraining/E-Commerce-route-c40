package com.example.e_commerce_route_c40.ui.fragments.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.Product
import com.route.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productsUseCase: GetProductsUseCase) :
    BaseViewModel() {

    val productsLiveData = MutableLiveData<List<Product>?>()

    fun getProducts(
        categoryId: String? = null,
        brandId: String? = null,
        subCategoryId: String? = null,
        keyword: String? = null,
    ) {
        showLoading(R.string.loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = productsUseCase.invoke(categoryId, brandId, subCategoryId, keyword)
                productsLiveData.postValue(products)
            } catch (ex: Exception) {
                handleError(ex)
            }
        }
        hideLoading()

    }
}