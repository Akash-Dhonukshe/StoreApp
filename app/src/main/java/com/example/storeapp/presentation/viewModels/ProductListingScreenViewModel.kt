package com.example.storeapp.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.model.ProductListResponseModel
import com.example.storeapp.domain.model.ProductsListRequestModel
import com.example.storeapp.domain.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListingScreenViewModel @Inject constructor(
    private val apiRepository : ApiRepository
) : ViewModel() {

    private val _productList = MutableLiveData<ProductListResponseModel>()

    val productList : LiveData<ProductListResponseModel> get() =
        _productList

    fun getProductList(productsListRequestModel : ProductsListRequestModel){
        viewModelScope.launch {
            val result = apiRepository.productsList(productsListRequestModel)
            _productList.value = result
        }
    }

}