package com.example.carphotoapp.fake

import com.example.carphotoapp.data.CarPhotoRepository
import com.example.carphotoapp.model.CarModel

class FakeNetworkCarPhotoRepository: CarPhotoRepository {
    override suspend fun getCarPhotos(): List<CarModel>{
        return FakeDataSource.photoList
    }
}