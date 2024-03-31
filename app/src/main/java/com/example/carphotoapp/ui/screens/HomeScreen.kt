package com.example.carphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.carphotoapp.R
import com.example.carphotoapp.model.CarModel
import com.example.carphotoapp.viewmodel.CarUiState
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip


@Composable

fun HomeScreen(
    carUiState:CarUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when( carUiState){
        is CarUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is CarUiState.Success -> PhotoGridSceen(photos = carUiState.photos)
        is CarUiState.Error -> ErrorScreen(modifier =  modifier.fillMaxSize())

    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Error")

    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.loader)
            , contentDescription = "Cargando")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos )
    }
}


@Composable
fun CarPhotoCard(photo: CarModel, modifier: Modifier){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photo.download_url)
            .crossfade(true)
            .build()

        ,

        contentDescription = stringResource(R.string.car_image),
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape),
        error= painterResource(id = R.drawable.error_404),
        placeholder = painterResource(id = R.drawable.carga),
        contentScale = ContentScale.Crop,



        )
}



@Composable
fun PhotoGridSceen(
    photos: List<CarModel>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(250.dp) ,
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ){
        items(
            items= photos,
            key = {photo -> photo.id}
        ){
                photo -> CarPhotoCard(photo = photo, modifier =modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1.5f)
        )
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        // HomeScreen(stringResource(R.string.placeholder_result))
    }

}