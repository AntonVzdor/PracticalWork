package com.example.practicalwork.UiScreenApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.practicalwork.Data.AmphibianData
import com.example.practicalwork.R
import com.example.practicalwork.ViewModel.AmphibiansViewModel
import com.example.practicalwork.ViewModel.UiState

//вертикальный список
@Composable
fun AmphibiansScreen(viewModel: AmphibiansViewModel = viewModel()) {
    Column {
        TopBarOfAmphibians()
        when (val state = viewModel.uiState) {
            is UiState.Loading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                LazyColumn {
                    items(state.data) { item ->
                        ItemOfAmphibians(item)
                    }
                }
            }

            is UiState.Error -> {
                Text(text = state.message)
            }
        }
    }
}

//элемент списка
@Composable
fun ItemOfAmphibians(
    item: AmphibianData
){
    Box(modifier = Modifier
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
                model = item.imgUrl,
                contentDescription = item.name
            )
            Text(
                text = item.description
            )
        }
    }
}