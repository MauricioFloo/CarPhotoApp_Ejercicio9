package com.example.carphotoapp.fake

import com.example.carphotoapp.model.CarModel

object FakeDataSource {
    const val idOne = "idCar1"
    const val idTwo = "idCar2"
    const val authorOne="author.1"
    const val authorTwo="author.2"
    const val urlOne = "url.1"
    const val urlTwo = "url.2"
    const val widthOne = 225
    const val heigtOne = 225
    const val widthTwo = 125
    const val heightTwo = 125
    const val download_urlOne="download_url.1"
    const val download_urlTwo="download_url.2"



    val photoList = listOf(
        CarModel(
            idOne,
            urlOne,
            widthOne,
            heightTwo,
            authorOne,
            download_urlOne
        ),
        CarModel(idTwo,
            urlTwo,
            widthTwo,
            heightTwo,
            authorTwo,
            download_urlTwo
        )
    )
}