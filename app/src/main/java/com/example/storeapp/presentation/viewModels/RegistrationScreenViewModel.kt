package com.example.storeapp.presentation.viewModels

import android.text.Editable
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import com.example.storeapp.domain.repository.ApiRepository
import com.example.storeapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationScreenViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {
    private val TAG = "RegistrationScreenViewModel"

    private val _registrationStatus = MutableLiveData<NetworkResult<RegisterResponseModel>>()

    val registrationStatus: LiveData<NetworkResult<RegisterResponseModel>> get() = _registrationStatus


    fun registerUser(registerRequestModel: RegisterRequestModel) {
        viewModelScope.launch {
            val result = apiRepository.registerUser(registerRequestModel)
            _registrationStatus.value = result
        }
    }

    fun loginUser(loginRequestModel: LoginRequestModel) {
        viewModelScope.launch {
            apiRepository.loginUser(loginRequestModel)
        }
    }

    fun validateCredentials(firstName: String, lastName: String, email: String, password: String, phoneNumber: Editable, confirmPassword : String) : Pair<Boolean, String>
    {
        var result = Pair(true, "")
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            result = Pair(false, "Please provide valid credentials")
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            result = Pair(false, "Please provide valid email")
        }
        else if (password.length<= 5){
            result = Pair(false, "Please provide valid password")
        }
        else if (!Patterns.PHONE.matcher(phoneNumber.toString()).matches()){
            result = Pair(false, "Please provide valid phone number")
        }
        else if (confirmPassword != password){
            result = Pair(false, "Please check confirm password")
        }
            return result
    }


}



