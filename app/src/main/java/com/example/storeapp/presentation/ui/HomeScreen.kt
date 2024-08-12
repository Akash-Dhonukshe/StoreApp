package com.example.storeapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentHomeScreenBinding

class HomeScreen : BaseFragment<FragmentHomeScreenBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeScreenBinding.inflate(inflater, container, false)


}