package com.example.e_commerce_route_c40.ui.fragments.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.Product
import com.route.domain.model.SubCategory
import com.route.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsUseCase: GetProductsUseCase,
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel() {

    val productsLiveData = MutableLiveData<List<Product>?>()

    private val subCategory: SubCategory? = savedStateHandle["subCategory"]
    fun getProducts() {
        showLoading(R.string.loading)
//        Log.e("TAg catesdsdasdasdgoryId", subCategory?.id.toString())
//        Log.e("TAg subCategoryId", subCategory.toString())
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = productsUseCase.invoke(categoryId = subCategory?.id)
                productsLiveData.postValue(products)
            } catch (ex: Exception) {
                handleError(ex)
            }
        }
        hideLoading()

    }
}