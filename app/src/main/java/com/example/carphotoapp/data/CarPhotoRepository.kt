package com.example.carphotoapp.data


import com.example.carphotoapp.model.CarModel
import com.example.carphotoapp.network.CarApiService

interface CarPhotoRepository{
    suspend fun getCarPhotos(): List<CarModel>
}

class NetworkCarPhotoRepository(
    private val carApiService: CarApiService
): CarPhotoRepository{
    override suspend fun getCarPhotos(): List<CarModel> = carApiService.getPhotos()
}