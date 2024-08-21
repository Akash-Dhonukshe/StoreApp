package com.example.storeapp.domain.model

import com.google.gson.annotations.SerializedName

data class RegisterResponseModel(
    val status: Int,
    @SerializedName("data")
    val data: RegisterData,
    val message: String,
    @SerializedName("user_message")
    val userMessage: String
)

data class RegisterData(
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
    val phoneNo: Long,
    @SerializedName("is_active")
    val isActive: Boolean,
    val created: String,
    val modified: String,
    @SerializedName("access_token")
    val accessToken: String
)
