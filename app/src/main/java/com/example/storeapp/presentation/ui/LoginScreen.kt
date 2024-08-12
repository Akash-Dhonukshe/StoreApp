package com.example.storeapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentLoginScreenBinding

class LoginScreen : BaseFragment<FragmentLoginScreenBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginScreenBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.dontHaveAnAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
        }

        return binding.root
    }

}


