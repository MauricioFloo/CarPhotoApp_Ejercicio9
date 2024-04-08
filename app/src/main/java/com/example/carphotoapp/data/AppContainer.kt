package com.example.carphotoapp.data

import com.example.carphotoapp.network.CarApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val carPhotoRepository: CarPhotoRepository
}

class DefaultAppContainer: AppContainer{

    private val baseUrl = "https://picsum.photos"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val retrofitService: CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
    override val carPhotoRepository: CarPhotoRepository by lazy{
        NetworkCarPhotoRepository(retrofitService)
    }
}