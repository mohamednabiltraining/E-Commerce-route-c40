package com.example.e_commerce_route_c40.ui.fragments.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.Category
import com.route.domain.model.SubCategory
import com.route.domain.usecase.GetCategoriesUseCase
import com.route.domain.usecase.GetSubCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getSubCategoriesUseCase: GetSubCategoriesUseCase
) :BaseViewModel() {
    val categoriesLiveData = MutableLiveData<List<Category>?>()
    val subCategoriesLiveData = MutableLiveData<List<SubCategory>?>()

    fun getCategories(){
        showLoading(R.string.loading)
        viewModelScope.launch (Dispatchers.IO){
            try {
                val categories =  getCategoriesUseCase.invoke()
                categoriesLiveData.postValue(categories)
            }catch (ex:Exception){
                handleError(ex)
            }
        }
        hideLoading()

    }
    fun getSubCategories(categoryId:String){
        showLoading(R.string.loading)
        viewModelScope.launch (Dispatchers.IO){
            try {
                val subCategories =  getSubCategoriesUseCase.invoke(categoryId)
                subCategoriesLiveData.postValue(subCategories)
            }catch (ex:Exception){
                handleError(ex)
            }
        }
        hideLoading()

    }
}