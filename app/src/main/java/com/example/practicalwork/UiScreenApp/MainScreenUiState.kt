package com.example.practicalwork.UiScreenApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.practicalwork.Data.AmphibiansDataClass
import com.example.practicalwork.R
import com.example.practicalwork.ViewModel.AmphibiansViewModel

//вертикальный список
@Composable
fun ListOfAmphibians(
    list: List<AmphibiansDataClass>,
    viewModel: AmphibiansViewModel,

    ) {

    val uiState by viewModel.uiAmphibians.collectAsState()

    Scaffold(
        topBar = { TopBarOfAmphibians() }
    ) { innerPadding ->
    LazyColumn(modifier = Modifier.padding(paddingValues = innerPadding)) {
        items(items = uiState, key = {item -> item.id}) { item ->
            ItemOfAmphibians(item = item)
        }
    }
}
}

//элемент списка
@Composable
fun ItemOfAmphibians(
    modifier: Modifier = Modifier,
    item: AmphibiansDataClass
){
    Box(modifier = modifier
        .fillMaxSize()
        .padding(all = 15.dp)
        .background(color = colorResource(R.color.teal_200))
        ){
        Column {
            Text(
                text = item.name
            )
            Text(
                text = item.type
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(item.imgUrl),
                contentDescription = item.name
            )
            Text(
                text = item.description
            )
        }
    }
}