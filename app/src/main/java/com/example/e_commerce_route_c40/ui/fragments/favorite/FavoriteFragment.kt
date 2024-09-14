package com.example.e_commerce_route_c40.ui.fragments.favorite



import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.adapters.FavoriteProductAdapter
import com.example.e_commerce_route_c40.databinding.FragmentFavorateBinding
import com.example.e_commerce_route_c40.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavorateBinding,FavoriteViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_favorate
    }

    private lateinit var adapterProduct: FavoriteProductAdapter

    private val _viewModel : FavoriteViewModel by viewModels()

    override fun initViewModel(): FavoriteViewModel {
        return _viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterProduct = FavoriteProductAdapter()

        observeLiveData()
        viewModel.getWishlist()
    }

    private fun observeLiveData() {
        viewModel.wishlistLiveData.observe(viewLifecycleOwner) { products ->
            products?.let { adapterProduct.updateProducts(it) }
        }
    }
}