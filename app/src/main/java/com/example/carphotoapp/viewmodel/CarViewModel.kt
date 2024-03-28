package com.example.carphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carphotoapp.model.CarModel
import com.example.carphotoapp.network.CarApi
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

class CarViewModel:ViewModel() {
    var carUiState: CarUiState by mutableStateOf(CarUiState.Loading)
        private set

    init {
        getCarPhotos()
    }

    private  fun getCarPhotos(){
        viewModelScope.launch {
            carUiState = try {
                val listResult = CarApi.retrofitService.getPhotos()
                CarUiState.Success(listResult)
            } catch (e: IOException){
                CarUiState.Error
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