package com.example.storeapp.domain.model

import com.google.gson.annotations.SerializedName

data class ProductListResponseModel(
    val status : Int,
    val data : List<ProductData>
)

data class ProductData(
    val id: Int,
    @SerializedName("product_category_id") val productCategoryId: String,
    val name: String,
    val producer: String,
    val description: String,
    val cost: Int,
    val rating: Int,
    @SerializedName("view_count") val viewCount: Int,
    val created: String,
    val modified: String,
    @SerializedName("product_images") val productImages: String
)