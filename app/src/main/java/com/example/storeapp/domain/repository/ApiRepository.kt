package com.example.storeapp.domain.repository

import android.util.Log
import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.LoginResponseModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import com.example.storeapp.network.ApiCallState
import com.example.storeapp.network.ApiService
import com.example.storeapp.utils.Constants.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun registerUser(registerRequestModel: RegisterRequestModel){
        val response = apiService.registerApi(
            registerRequestModel.firstName,
            registerRequestModel.lastName,
            registerRequestModel.email,
            registerRequestModel.password,
            registerRequestModel.confirmPassword,
            registerRequestModel.gender,
            registerRequestModel.phoneNumber
        )
        Log.d(TAG, "registerUser: ${response.status}")
    }

    suspend fun loginUser(loginRequestModel: LoginRequestModel){
        val response = apiService.loginApi(
            loginRequestModel.email,
            loginRequestModel.password
        )
        Log.d(TAG, "loginUser: ${response.status}")
    }
}


