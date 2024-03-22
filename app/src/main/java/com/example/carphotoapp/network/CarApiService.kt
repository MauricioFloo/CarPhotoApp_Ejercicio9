package com.example.carphotoapp.network

import com.example.carphotoapp.model.CarModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL =  "https://picsum.photos"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType() ) )
    .baseUrl(BASE_URL)
    .build()

interface CarApiService{
    @GET("v2/list?page=1&limit=10&query=car")
    suspend fun  getPhotos():List<CarModel>
}
//PATRON DE DISEÑO Singleton

object CarApi{
    val retrofitService: CarApiService by lazy{
        retrofit.create(CarApiService::class.java)
    }
}