package com.example.e_commerce_route_c40.ui.fragments.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.route.domain.model.Product
import com.route.domain.usecase.GetWishlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getWishlistUseCase: GetWishlistUseCase
) : BaseViewModel() {
    val wishlistLiveData = MutableLiveData<List<Product>?>()
    fun getWishlist() {
        try {
            viewModelScope.launch (Dispatchers.IO){
                val product = getWishlistUseCase.invoke()
                wishlistLiveData.postValue(product)
            }
        }catch (e:Exception){
            handleError(e)
        }

    }
}