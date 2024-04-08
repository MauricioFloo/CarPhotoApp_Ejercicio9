package com.example.carphotoapp

import android.app.Application
import com.example.carphotoapp.data.AppContainer
import com.example.carphotoapp.data.DefaultAppContainer

class CarPhotoApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container= DefaultAppContainer()
    }
}