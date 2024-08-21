package com.example.storeapp.presentation.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.storeapp.R
import com.example.storeapp.databinding.FragmentRegisterScreenBinding
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.presentation.viewModels.RegistrationScreenViewModel
import com.example.storeapp.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterScreenFragment : Fragment() {
    private var _binding : FragmentRegisterScreenBinding? = null
    private val binding get() = _binding!!

    private val TAG = "RegisterScreen"

    private val viewModel : RegistrationScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerBtn.setOnClickListener {
            val validationResult = validateUserInput()
            if (validationResult.first) {
                viewModel.registerUser(
                    RegisterRequestModel(
                        binding.firstNameEt.text.toString(),
                        binding.lastNameEt.text.toString(),
                        binding.emailEt.text.toString(),
                        binding.passwordEt.text.toString(),
                        binding.confirmPasswordEt.text.toString(),
                        isMale(binding.radioMale.isChecked),
                        binding.phoneNumberEt.text.toString().toLong()
                    )
                )
            }
        }
        Log.d(TAG, "onViewCreated: ${onBindViewHolder()}")
        onBindViewHolder()
    }

    fun validateUserInput(): Pair<Boolean, String> {
        val firstName = binding.firstNameEt.text.toString()
        val lastName = binding.lastNameEt.text.toString()
        val email = binding.emailEt.text.toString()
        val password = binding.passwordEt.text.toString()
        val phoneNumber = binding.phoneNumberEt.text
        val confirmPassword = binding.confirmPasswordEt.text.toString()
        return viewModel.validateCredentials(firstName, lastName, email, password,  phoneNumber, confirmPassword)
    }

    private fun onBindViewHolder() {
        viewModel.registrationStatus.observe(viewLifecycleOwner, Observer {
            binding.loadingScreen.progressBar.isVisible = false
            when(it){
                is NetworkResult.Error -> {
                    Log.d(TAG, "onBindViewHolder: Data is in Error")
                    binding.errorText.text = it.message
                }
                is NetworkResult.Loading -> {
                    Log.d(TAG, "onBindViewHolder: Data is in Loading")
                    binding.loadingScreen.progressBar.isVisible = true
                }
                is NetworkResult.Success -> {
                    Log.d(TAG, "onBindViewHolder: Data is in success")
                    if (findNavController().currentDestination?.id == R.id.registerScreen) {
                        findNavController().navigate(R.id.action_registerScreen_to_homeScreen)
                    } else {
                        Log.d(TAG, "onBindViewHolder: Navigation skipped as current destination is not registerScreen")
                    }
                }
            }
        })
    }

    private fun isMale(isMaleValue : Boolean): String{
        return if (isMaleValue)"M" else "F"
    }

}