package com.example.carphotoapp.fake

import com.example.carphotoapp.model.CarModel

object FakeDataSource {
    const val idOne= "idCar1"
    const val idTwo= "idCar2"
    const val imgOne= "url.1"
    const val imgTwo= "url.2"
    const val widthOne= 225
    const val heigthOne= 225
    const val widthTwo= 125
    const val heigthTwo= 125

    val photoList= listOf(
        CarModel(
            idOne,
            imgOne,
            widthOne,
            heigthOne
        ),
        CarModel(
            idTwo,
            widthTwo,
            heigthTwo
        )
    )


}