package com.example.storeapp.presentation.ui.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import com.example.storeapp.domain.repository.ApiRepository
import com.example.storeapp.network.ApiCallState
import com.example.storeapp.network.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {
    private val TAG = "RegistrationScreenViewModel"

    private val _registrationStatus = MutableLiveData<ApiCallState<RegisterResponseModel>>()

    val registrationStatus: LiveData<ApiCallState<RegisterResponseModel>> get() = _registrationStatus


    fun registerUser(registerRequestModel: RegisterRequestModel) {
        viewModelScope.launch {
            apiRepository.registerUser(registerRequestModel)
        }

        fun loginUser(loginRequestModel : LoginRequestModel){
            viewModelScope.launch {
                apiRepository.loginUser(loginRequestModel)
            }
        }
    }

}



