package com.example.storeapp.domain.model

import com.google.gson.annotations.SerializedName

data class RegisterRequestModel(
    @SerializedName("first_name")
    val firstName : String,
    @SerializedName("last_name")
    val lastName : String,
    val email : String,
    val password : String,
    @SerializedName("confirm_password")
    val confirmPassword : String,
    val gender : String,
    @SerializedName("phone_no")
    val phoneNumber : Long

)
