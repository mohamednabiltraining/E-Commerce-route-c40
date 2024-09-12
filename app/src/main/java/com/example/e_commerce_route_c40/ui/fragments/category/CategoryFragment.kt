package com.example.e_commerce_route_c40.ui.fragments.category

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


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
                categoriesAdapter.changeData(categories)
            }
        }
        viewModel.subCategoriesLiveData.observe(viewLifecycleOwner) { subCategories ->
            subCategories?.let {
                subCategoriesAdapter.changeData(subCategories)
            }
            updateUiSubCategories()
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

    private fun updateUiSubCategories() {
        if (viewModel.subCategoriesLiveData.value.isNullOrEmpty()) {
            binding.apply {
                rvSubCategory.visibility = View.GONE
                layoutPlaceHolder.viewStub?.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                rvSubCategory.visibility = View.VISIBLE
                layoutPlaceHolder.viewStub?.visibility = View.GONE
            }

        }

    }
}