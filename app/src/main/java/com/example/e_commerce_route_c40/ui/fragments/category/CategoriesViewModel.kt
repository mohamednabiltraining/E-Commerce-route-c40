package com.example.e_commerce_route_c40.ui.fragments.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.ApiResult
import com.route.domain.model.Category
import com.route.domain.model.SubCategory
import com.route.domain.usecase.GetCategoriesUseCase
import com.route.domain.usecase.GetSubCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
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
        viewModelScope.launch {
            getCategoriesUseCase.invoke()
                .collect{result->
                    when(result){
                        is ApiResult.Failure -> handleError(result.throwable)
                        is ApiResult.Loading ->  handleLoading(result)
                        is ApiResult.Success ->{
                            categoriesLiveData.postValue(result.data)

                        }
                    }
                }
        }
    }
    fun getSubCategories(categoryId:String){

        viewModelScope.launch {
            getSubCategoriesUseCase.invoke(categoryId)
                .collect{result->
                    when(result){
                        is ApiResult.Failure -> handleError(result.throwable)
                        is ApiResult.Loading ->  handleLoading(result)
                        is ApiResult.Success ->{
                            subCategoriesLiveData.postValue(result.data)

                        }
                    }
                }
        }
        hideLoading()

    }
}