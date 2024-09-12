package com.example.e_commerce_route_c40.ui.fragments.product

import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentProductBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductBinding, ProductViewModel>() {
    private val _viewModel: ProductViewModel by viewModels()

    override fun initViewModel()    : ProductViewModel = _viewModel
    override fun getLayoutId()      : Int = R.layout.fragment_product


}