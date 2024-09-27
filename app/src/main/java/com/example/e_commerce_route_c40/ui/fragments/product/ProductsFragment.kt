package com.example.e_commerce_route_c40.ui.fragments.product

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentProductBinding
import com.route.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductBinding, ProductViewModel>() {

    private val _viewModel: ProductViewModel by viewModels()

  lateinit var adapter :ProductsAdaptor

    override fun initViewModel(): ProductViewModel = _viewModel

    override fun getLayoutId(): Int = R.layout.fragment_product

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLivedata()
        viewModel.getProductsByCategory()
    }

    private fun observeLivedata() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) { products ->
            if (products != null) {
                adapter.changeData(products)
            }
            updateUiProducts()
        }
        viewModel.productWishListUpdatePosition.observe(viewLifecycleOwner) { pos ->
            adapter.notifyItemChanged(pos)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initViews() {
        adapter = ProductsAdaptor()
        binding.rvProduct.adapter = adapter

        adapter.onFavoriteClickListener =
            ProductsAdaptor.OnItemClickListener { product, position ->
                viewModel.addProductToWishList(product)



                    }
        adapter.onItemClickListener =
            ProductsAdaptor.OnItemClickListener { product, position ->
                val act =
                    ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(product?: Product())
              Navigation.findNavController(binding.root).navigate(act)}


                binding.etSearch.setOnEditorActionListener { v, actionId, event ->
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                        val query = v.text.toString().trim()
                        viewModel.getProductsByKey(query)

                        return@setOnEditorActionListener true
                    } else return@setOnEditorActionListener false

                }
            }
    private fun updateUiProducts() {
        if (viewModel.productsLiveData.value.isNullOrEmpty()) {
            binding.apply {
                rvProduct.visibility = View.INVISIBLE
                layoutPlaceHolder.viewStub?.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvProduct.visibility = View.VISIBLE
                layoutPlaceHolder.viewStub?.visibility = View.GONE
            }

        }
    }}





