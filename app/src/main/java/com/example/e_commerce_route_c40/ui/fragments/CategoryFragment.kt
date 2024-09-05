package com.example.e_commerce_route_c40.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentCategoryBinding


class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentCategoryBinding.inflate(inflater,container,false)

    // now you can use binding directly



}