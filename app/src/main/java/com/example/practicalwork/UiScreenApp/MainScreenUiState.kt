package com.example.practicalwork.UiScreenApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.practicalwork.Data.AmphibianData
import com.example.practicalwork.ViewModel.AmphibiansViewModel
import com.example.practicalwork.ViewModel.UiState

//вертикальный список
@Composable
fun AmphibiansScreen(viewModel: AmphibiansViewModel = viewModel()) {
    Column(
        modifier = Modifier.padding(all = 5.dp)
    ) {
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

    val nameAndType = "${item.name} (${item.type})"

    Box(
        modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp)
        .background(
            Color(0xFFE0E0E0),
            shape = RoundedCornerShape(15.dp)
        )
    ){
        Column {
            Text(
                text = nameAndType,
                modifier = Modifier.padding(all = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            AsyncImage(
                model = item.imgUrl,
                contentDescription = item.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.description,
                modifier = Modifier.padding(all = 10.dp),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

