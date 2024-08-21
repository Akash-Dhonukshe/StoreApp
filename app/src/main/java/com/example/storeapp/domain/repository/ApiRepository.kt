package com.example.storeapp.domain.repository

import android.util.Log
import com.example.storeapp.domain.model.LoginRequestModel
import com.example.storeapp.domain.model.LoginResponseModel
import com.example.storeapp.domain.model.ProductListResponseModel
import com.example.storeapp.domain.model.ProductsListRequestModel
import com.example.storeapp.domain.model.RegisterRequestModel
import com.example.storeapp.domain.model.RegisterResponseModel
import com.example.storeapp.network.ApiService
import com.example.storeapp.utils.Constants.TAG
import com.example.storeapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun registerUser(registerRequestModel: RegisterRequestModel): NetworkResult<RegisterResponseModel> {
        return try {
            val response = apiService.registerApi(
                registerRequestModel.firstName,
                registerRequestModel.lastName,
                registerRequestModel.email,
                registerRequestModel.password,
                registerRequestModel.confirmPassword,
                registerRequestModel.gender,
                registerRequestModel.phoneNumber
            )

            if (response.status == 200) {
                NetworkResult.Success(response)
            } else {
                NetworkResult.Error(response.message, response)
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "An error occurred", null)
        }
    }




    suspend fun loginUser(loginRequestModel: LoginRequestModel){
        val response = apiService.loginApi(
            loginRequestModel.email,
            loginRequestModel.password
        )
        Log.d(TAG, "loginUser: ${response.status}")
    }

    suspend fun productsList(productsListRequestModel: ProductsListRequestModel) : ProductListResponseModel{
        val response = apiService.getProductsListApi(
            productsListRequestModel.productCategoryId,
            productsListRequestModel.limit,
            productsListRequestModel.page
        )
        return response
    }
}


