package com.example.e_commerce_route_c40.ui.fragments.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.ApiResult
import com.route.domain.model.Product
import com.route.domain.usecase.GetWishlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getWishlistUseCase: GetWishlistUseCase
) : BaseViewModel() {
    val wishlistLiveData = MutableLiveData<List<Product>?>()
    fun getWishlist() {
            viewModelScope.launch {
                getWishlistUseCase.invoke()
                    .flowOn((Dispatchers.IO))
                    .collect{result->
                        when(result){
                            is ApiResult.Failure -> handleError(result.throwable)
                            is ApiResult.Loading ->  handleLoading(result)
                            is ApiResult.Success ->{
                                wishlistLiveData.postValue(result.data)

                            }
                        }
                    }
            }
    }
}