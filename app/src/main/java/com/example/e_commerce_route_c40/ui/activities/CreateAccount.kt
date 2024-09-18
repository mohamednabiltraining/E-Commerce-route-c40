package com.example.e_commerce_route_c40.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.e_commerce_route_c40.R
import com.example.e_commerce_route_c40.base.BaseFragment
import com.example.e_commerce_route_c40.databinding.FragmentCreateAccountBinding

class CreateAccount : BaseFragment<FragmentCreateAccountBinding, CreateAccountViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_create_account

    private val _viewModel: CreateAccountViewModel by viewModels ()

    override fun initViewModel(): CreateAccountViewModel {
        return _viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.createVM = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }


}