package com.example.storeapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentHomeScreenBinding
import com.example.storeapp.presentation.adapter.ViewPagerAdapter
import com.example.storeapp.presentation.viewModels.HomeScreenViewModel

class HomeScreen : BaseFragment<FragmentHomeScreenBinding>() {
    private lateinit var viewModel: HomeScreenViewModel
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeScreenBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val images = listOf(
            R.drawable.chair,
            R.drawable.sofa,
            R.drawable.table,
            R.drawable.cupboard
        )

        val adapter = ViewPagerAdapter(images)
        binding.viewPager.adapter = adapter
        binding.viewPager.beginFakeDrag()
        binding.viewPager.fakeDragBy(-10f)
        binding.viewPager.endFakeDrag()

        binding.itemTable.itemLayout.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreen_to_productListingScreen)
        }
    }




}