package com.example.carphotoapp.viewmodel

import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.carphotoapp.CarPhotoApplication
import com.example.carphotoapp.data.CarPhotoRepository
import com.example.carphotoapp.data.NetworkCarPhotoRepository
import com.example.carphotoapp.model.CarModel

import com.example.carphotoapp.network.CarApiService
import kotlinx.coroutines.launch
import java.io.IOException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers


sealed interface  CarUiState {
    data class Success(val photos: List<CarModel>):CarUiState
    object Error: CarUiState
    object Loading: CarUiState
}

class CarViewModel(private val carPhotoRepository: CarPhotoRepository):ViewModel() {
    var carUiState: CarUiState by mutableStateOf(CarUiState.Loading)
        private set

    init {
        getCarPhotos()
    }

    private  fun getCarPhotos(){
        viewModelScope.launch {
            carUiState = try {
                val listResult = carPhotoRepository.getCarPhotos()
                CarUiState.Success(listResult)
            } catch (e: IOException){
                CarUiState.Error
            }

        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as CarPhotoApplication)
                val carPhotoRepository = application.container.carPhotoRepository
                CarViewModel(carPhotoRepository = carPhotoRepository)
            }
        }
    }

}

/*private  fun getCarPhotos(){
         viewModelScope.launch {
            catUiState = try {
                 val listResult = CatApi.retrofitService.getPhotos()
                CatUiState.Success(listResult)
             } catch (e: IOException){
                 CatUiState.Error
             }

         }
    }

 */