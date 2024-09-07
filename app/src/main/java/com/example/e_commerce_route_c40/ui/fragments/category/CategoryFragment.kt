package com.example.e_commerce_route_c40.ui.fragments.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.base.BaseViewModel
import com.example.e_commerce_route_c40.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding,CategoriesViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_category
    }

    private val _viewModel :CategoriesViewModel by viewModels ()
    override fun initViewModel(): CategoriesViewModel {
     return _viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeLivedata()
        viewModel.getCategories()
    }

    private fun observeLivedata() {
        viewModel.categoriesLiveData.observe(viewLifecycleOwner){categories->
            categories?.let {
                categoriesAdapter.addDataToList(items = it)
            }
        }
        viewModel.subCategoriesLiveData.observe(viewLifecycleOwner){
            subCategories->
            subCategories?.let {
                subCategoriesAdapter.changeData(subCategories)
            }
        }
    }

    private val categoriesAdapter = CategoriesAdapter()
    private val subCategoriesAdapter = SubCategoriesAdapter()
    private fun initViews() {
        categoriesAdapter.onItemClickListener = CategoriesAdapter.OnItemClickListener { category, position ->
            viewModel.getSubCategories(category?.id ?:"")
        }
        binding.apply {
            rvCategory.adapter =categoriesAdapter
            rvSubCategory.adapter = subCategoriesAdapter
        }
    }


}