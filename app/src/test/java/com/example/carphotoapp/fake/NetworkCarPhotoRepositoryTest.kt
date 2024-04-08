package com.example.carphotoapp.fake

import com.example.carphotoapp.data.NetworkCarPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*


class NetworkCarPhotoRepositoryTest{
    @Test
    fun networkCarPhotoRepository_getCarPhotos_verifyPhotoList(){
        runTest {
            val repository = NetworkCarPhotoRepository(
                carApiService= FakeCarApiService()
            )
            assertEquals(FakeDataSource.photoList,repository.getCarPhotos())
        }
    }
}