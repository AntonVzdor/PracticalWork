package com.example.practicalwork

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
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
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyVerticalGrid(
        contentPadding = contentPadding,
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

        modifier = modifier.padding(5.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

                Text(text = stringResource(photo.namePhoto))

                Image(
                    painter = painterResource(photo.imagePhoto),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = stringResource(id = photo.descriptionPhoto),
                    modifier = Modifier
                )
            }
        }
    }

@Preview
@Composable
fun PhotoPreview(){
    PhotoCard()
}