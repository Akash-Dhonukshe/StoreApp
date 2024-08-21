package com.example.storeapp.domain.model

import com.google.gson.annotations.SerializedName

data class ProductsListRequestModel(
    @SerializedName("product_category_id")
    val productCategoryId : String,
    val limit : Int,
    val page : Int
)
