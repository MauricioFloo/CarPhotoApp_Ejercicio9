package com.example.carphotoapp.fake

import com.example.carphotoapp.viewmodel.CarUiState
import com.example.carphotoapp.viewmodel.CarViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import com.example.carphotoapp.fake.rules.TestDispatcherRule
import org.junit.Assert.assertEquals

class CarViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun carViewModel_getCarPhotos_verifyCarUiStateSuccess(){
        runTest {
            val carViewModel = CarViewModel(
                carPhotoRepository = FakeNetworkCarPhotoRepository()
            )
            assertEquals(CarUiState.Success(FakeDataSource.photoList),carViewModel.carUiState)
        }
    }
}