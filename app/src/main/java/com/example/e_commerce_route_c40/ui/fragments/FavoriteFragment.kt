package com.example.e_commerce_route_c40.ui.fragments


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.databinding.FragmentFavorateBinding
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.base.BaseViewModel


class FavoriteFragment : BaseFragment<FragmentFavorateBinding,BaseViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_favorate
    }

    private val _viewModel : BaseViewModel by viewModels ()
    override fun initViewModel(): BaseViewModel {
        return _viewModel
    }


}