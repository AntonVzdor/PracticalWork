package com.example.practicalwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.model.DataSource
import com.example.practicalwork.model.PhotoAlbumData


@Composable
fun PhotoCard(
    photo: List<PhotoAlbumData>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(contentPadding = contentPadding) {
        itemsIndexed(photo){
            index, photo ->
            PhotoCardItem(
                photo = photo,
                modifier = modifier)
        }
    }
}

@Composable
fun PhotoCardItem(photo: PhotoAlbumData, modifier: Modifier  = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
                .sizeIn(minHeight = 150.dp)
        ) {
            Text(text = stringResource(photo.namePhoto))
            Image(
                painter = painterResource(photo.imagePhoto),
                contentDescription = null,
                contentScale = ContentScale.Crop)
            Text(text = stringResource(id = photo.descriptionPhoto))
        }
    }
}