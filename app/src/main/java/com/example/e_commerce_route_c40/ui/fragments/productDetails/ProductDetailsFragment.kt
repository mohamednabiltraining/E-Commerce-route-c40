package com.example.e_commerce_route_c40.ui.fragments.productDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentProductDetailsBinding
import com.route.domain.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment
 :BaseFragment<FragmentProductDetailsBinding,ProductDetailsVm>() {

    private  val _viewModel :ProductDetailsVm by viewModels()
    val args: ProductDetailsFragmentArgs by navArgs()
    val adapter = ProductImagesAdapter()

    override fun initViewModel(): ProductDetailsVm {
    return _viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val  product : Product = args.product

        super.onViewCreated(view, savedInstanceState)
        initViews()
       observeLiveData()
        val testResult=_viewModel.getSpecificProduct(product.id!!)
        Log.e( "testResulr" , testResult. toString())



    }

    private fun observeLiveData() {
        _viewModel._productLifeData.observe(viewLifecycleOwner) { product ->
            Log.e("Product -> ", product.sold.toString()  )
            product?.let {
               setData(product)
                if (product.images?.isNotEmpty() == true){
                    adapter.changeData(product.images ?: listOf())

                }

            }
        }
    }


    private fun setData(product: Product?) {

        binding.apply {
           TvSold.text="${product?.sold.toString()} sold"
           TvPrice.text = "${product?.price}"
          TvDescriptionText.text = "${product?.description}"
           TvTitle.text = "${product?.title}"
           TvRating.text ="${product?.ratingsAverage} (${product?.ratingsQuantity})"
            RvProductImage.adapter=adapter

        }
    }

    private fun initViews() {
        binding.apply {
            vm = _viewModel
            lifecycleOwner = viewLifecycleOwner

        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.RvProductImage)

    }

    override fun getLayoutId(): Int {
        return  R.layout.fragment_product_details
    }

}
