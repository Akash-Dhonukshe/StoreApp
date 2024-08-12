package com.example.storeapp.network

import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.LoginResponseModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
@FormUrlEncoded
    @POST("users/register")
    suspend fun registerApi(
        @Field("first_name") firstName : String,
        @Field("last_name") lastName : String,
        @Field ("email") email : String,
        @Field ("password") password : String,
        @Field("confirm_password") confirmPassword : String,
        @Field ("gender") gender : String,
        @Field("phone_no") phoneNumber : Int
    ): RegisterResponseModel

    @FormUrlEncoded
    @POST("users/login")
    suspend fun loginApi(
        @Field ("email") email : String,
        @Field ("password") password : String
    )
    : LoginResponseModel
}