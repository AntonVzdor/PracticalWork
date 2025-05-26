package com.example.practicalwork.UiScreenApp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.practicalwork.Data.AmphibianData
import com.example.practicalwork.R
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

    Card (
        modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp)
        .background(
            Color(0xFFAFACAC),
            shape = RoundedCornerShape(15.dp)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column {
            Text(
                text = nameAndType,
                modifier = Modifier.padding(all = 10.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF000000)
            )
            AsyncImage(
                model = item.imgUrl,
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = item.description,
                modifier = Modifier.padding(all = 10.dp),
                fontWeight = FontWeight.Medium,
                color = Color(0xFF000000)
            )
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen(){
    AmphibiansScreen()
}