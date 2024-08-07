package com.example.storeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentRegisterScreenBinding

class RegisterScreen : BaseFragment<FragmentRegisterScreenBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentRegisterScreenBinding.inflate(inflater, container, false)

}