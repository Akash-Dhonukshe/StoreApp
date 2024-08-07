package com.example.storeapp.network

import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.LoginResponseModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("users/register")
    suspend fun registerApi(
        @Body registerRequestModel: RegisterRequestModel
    ): RegisterResponseModel

    @POST("users/login")
    suspend fun loginApi(
        @Body loginRequestModel: LoginRequestModel
    )
    : LoginResponseModel
}