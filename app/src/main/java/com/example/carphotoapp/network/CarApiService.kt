package com.example.carphotoapp.network

import com.example.carphotoapp.model.CarModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.http.Headers


interface CarApiService{
    @GET("v2/list?page=10&limit=20&query=car")
    suspend fun  getPhotos():List<CarModel>
}


