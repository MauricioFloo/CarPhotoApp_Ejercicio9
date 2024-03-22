package com.example.carphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carphotoapp.network.CarApi
import com.google.firebase.storage.ListResult
import kotlinx.coroutines.launch
import java.io.IOException
sealed interface  CarUiState {
    data class Success(val photos:String):CarUiState
    object Error: CarUiState
    object Loading: CarUiState
}

class CarViewModel:ViewModel() {
    var carUiState:CarUiState by mutableStateOf(CarUiState.Loading)
        private set
    init{
        getCarPhotos()
    }
    fun getCarPhotos(){
        viewModelScope.launch {
            carUiState = try{
                val listResult = CarApi.retrofitService.getPhotos()
                CarUiState.Success("Número de carros reicibidos es: ${listResult}")
            }
            catch (e: IOException){
                CarUiState.Error
            }

        }
    }

}