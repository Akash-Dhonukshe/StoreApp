package com.example.storeapp.di

import com.example.storeapp.domain.repository.ApiRepository
import com.example.storeapp.network.ApiService
import com.example.storeapp.network.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providesApiRepository(apiService: ApiService): ApiRepository{
        return ApiRepository(apiService)
    }

    @Singleton
    @Provides
    fun providesApiService(): ApiService{
        return RetrofitHelper.getInstance().create(ApiService::class.java)
    }
}