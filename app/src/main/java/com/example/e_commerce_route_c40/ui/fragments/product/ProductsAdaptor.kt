package com.example.e_commerce_route_c40.ui.fragments.product

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.e_commerce_route_c40.base.BaseAdapter
import com.example.e_commerce_route_c40.databinding.ItemProductBinding
import com.route.domain.model.Category
import com.route.domain.model.Product
import javax.inject.Inject

class ProductsAdaptor @Inject constructor(alertDialog: AlertDialog) :
    BaseAdapter<Product, ItemProductBinding>(alertDialog) {


    override fun getBinding(parent: ViewGroup, viewType: Int): ItemProductBinding {
        return ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindData(binding: ItemProductBinding, item: Product, position: Int) {
        binding.tvProductDetails.text = item.title
        binding.tvProductPrice.text = buildString {
            append(item.price?.toString())
            append(" $")
        }

        binding.tvProductReviewValue.text = item.ratingsAverage.toString()

        Glide.with(binding.root.context)
            .load(item.imageCover)
            .into(binding.imgProduct)
    }


    fun interface OnItemClickListener {
        fun onItemClick(category: Category?, position: Int)
    }
}