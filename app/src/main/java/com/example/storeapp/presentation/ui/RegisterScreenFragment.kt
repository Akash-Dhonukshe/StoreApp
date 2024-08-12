package com.example.storeapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.storeapp.R
import com.example.storeapp.base.BaseFragment
import com.example.storeapp.databinding.FragmentRegisterScreenBinding
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.network.Status
import com.example.storeapp.presentation.ui.viewModels.RegistrationScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterScreenFragment : Fragment() {
    private var _binding : FragmentRegisterScreenBinding? = null
    private val binding get() = _binding!!

    private val TAG = "RegisterScreen"

    private val viewModel : RegistrationScreenViewModel by viewModels()
//    override fun getFragmentBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    )= FragmentRegisterScreenBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterScreenBinding.inflate(inflater, container, false)
        binding.registerBtn.setOnClickListener {
            viewModel.registerUser(
                RegisterRequestModel(
                    binding.firstNameEt.text.toString(),
                    binding.lastNameEt.text.toString(),
                    binding.emailEt.text.toString(),
                    binding.passwordEt.text.toString(),
                    binding.confirmPasswordEt.text.toString(),
                    isMale(binding.radioMale.isChecked),
                    binding.phoneNumberEt.text.toString().toInt()))
        }
        return binding.root
    }

//    override fun initialSetUp() {
//        onClickListeners()
//    }

//    fun onClickListeners(){
//        binding.registerBtn.setOnClickListener {
//            val firstName = binding.firstNameEt.text.toString()
//            val lastName = binding.lastNameEt.text.toString()
//            val email = binding.emailEt.text.toString()
//            val password = binding.passwordEt.text.toString()
//            val confirmPassword = binding.confirmPasswordEt.text.toString()
//            val gender = binding.radioGenderGroup.id
//            val phoneNumber = binding.phoneNumberEt.text.toString()
//            val registerResponseModel = RegisterRequestModel(
//                firstName, lastName, email, password, confirmPassword, phoneNumber, gender
//            )
//            viewModel.registerUser(registerResponseModel)
//        }
//
//    }

    private fun isMale(isMaleValue : Boolean): String{
        return if (isMaleValue)"M" else "F"
    }

}