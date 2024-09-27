package com.example.e_commerce_route_c40.ui.fragments.productDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.e_commerce_route_c40.base.BaseAdapter
import com.example.e_commerce_route_c40.databinding.ItemImageBuilderBinding

class ProductImagesAdapter :BaseAdapter<String,ItemImageBuilderBinding> (){
    override fun getBinding(parent: ViewGroup, viewType: Int): ItemImageBuilderBinding {
        return  ItemImageBuilderBinding.inflate(LayoutInflater.from(parent.context), parent , false)
    }

    override fun bindData(binding: ItemImageBuilderBinding, item: String, position: Int) {
        Glide.with(binding.root)
            .load(item)
            .into(binding.imageProduct)
    }
}