package com.example.carphotoapp.fake

import com.example.carphotoapp.model.CarModel
import com.example.carphotoapp.network.CarApiService

class FakeCarApiService:CarApiService {
    override suspend fun getPhotos(): List<CarModel>{
        return FakeDataSource.photoList
    }
}