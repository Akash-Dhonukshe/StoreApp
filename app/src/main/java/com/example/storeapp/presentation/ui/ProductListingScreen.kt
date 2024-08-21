package com.example.storeapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentProductListingScreenBinding
import com.example.storeapp.domain.model.ProductListResponseModel
import com.example.storeapp.domain.model.ProductsListRequestModel
import com.example.storeapp.presentation.viewModels.ProductListingScreenViewModel

class ProductListingScreen : BaseFragment<FragmentProductListingScreenBinding>() {
    private lateinit var viewModel: ProductListingScreenViewModel
    private val TAG = "ProductListingScreen"

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProductListingScreenBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    }

