package com.example.storeapp.domain.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    val status: Boolean,
    @SerializedName("data")
    val data: LoginData,
    val message: String,
    @SerializedName("user_message")
    val userMessage: String

)

data class LoginData(
    val id: Int,
    @SerializedName("role_id")
    val roleId: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    val username: String,
    val gender: String,
    @SerializedName("phone_no")
    val phoneNo: Int,
    @SerializedName("is_active")
    val isActive: Boolean,
    val created: String,
    val modified: String,
    @SerializedName("access_token")
    val accessToken: String
)




