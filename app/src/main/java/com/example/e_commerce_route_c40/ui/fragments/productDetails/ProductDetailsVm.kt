package com.example.e_commerce_route_c40.ui.fragments.productDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.data.api.interceptor.IODispatcher
import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.repositories.ProductsRepository
import com.route.domain.usecase.product.GetSpecificProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ProductDetailsVm @Inject constructor(
 private   val useCase: GetSpecificProductUseCase,

) : BaseViewModel()  {

 val _productLifeData = MutableLiveData<Product>()

   private val _isExpandedLiveData = MutableLiveData<Boolean>()
    val isExpandedLiveData :LiveData<Boolean>get() = _isExpandedLiveData
     var _counterLiveData = MutableLiveData<Int>()

   private var _totalPriceLiveData = MutableLiveData<Int>()
    val totalPriceLiveData :LiveData<Int>get()=_totalPriceLiveData
    private var _price = MutableLiveData<Int>()
    val price :LiveData<Int>get()=_price




    init {
        _isExpandedLiveData.value = false
        _counterLiveData.value = 0
        _price.value = 0
    }

 fun toggleDescription(){

             _isExpandedLiveData.value = _isExpandedLiveData.value?.not()
 }
    fun incrementCounter (){
        _counterLiveData.value = (_counterLiveData.value ?: 0) + 1
        getTotalPrice ()

    }
    fun decreasesCounter (){
        if (_counterLiveData.value!=0){
            _counterLiveData.value = (_counterLiveData.value ?: 0) -1
            getTotalPrice ()
        }
        else return

    }
    private fun getTotalPrice (){
        _totalPriceLiveData.value = (_price.value ?: 0) * (_counterLiveData.value ?: 0)
    }

    fun getSpecificProduct(productId:String){
        viewModelScope.launch  {
            useCase.invoke(productId = productId)
                .collect{response ->
                    Log.e("response ->", response.toString())

                when(response){
                    is ApiResult.Failure -> handleError(response.throwable)
                    is ApiResult.Loading ->handleLoading(response)
                    is ApiResult.Success ->{
                        _price.postValue(response.data.price?:0)
                        _productLifeData.postValue(response.data)}

                }
            }
        }
    }



}