package com.example.practicalwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.model.DataSource
import com.example.practicalwork.model.PhotoAlbumData


@Composable
fun PhotoCard(
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = modifier) {
        items(DataSource.photo) { photo ->
            PhotoCardItem(photo)
        }
    }
}

@Composable
fun PhotoCardItem(photo: PhotoAlbumData, modifier: Modifier  = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = modifier.padding(10.dp)
    ) {

        var expanded by remember { mutableStateOf(false) }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = stringResource(photo.namePhoto))

            Image(
                painter = painterResource(photo.imagePhoto),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .fillMaxWidth())

            Text(text = stringResource(id = photo.descriptionPhoto))

        }
    }
}

@Preview
@Composable
fun PhotoPreview(){
    PhotoCard()
}