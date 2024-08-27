package com.example.practicalwork

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            PhotoCardItem(
                photo)
        }
    }
}

@Composable
fun PhotoCardItem(
    photo: PhotoAlbumData,
    modifier: Modifier  = Modifier
){
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(5.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    expanded = !expanded
                }
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    )
    {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(photo.namePhoto),
                    modifier = Modifier
                        .padding(
                        start = 2.dp,
                        end = 2.dp
                    ),style = MaterialTheme.typography.labelLarge,
                    fontSize = 17.sp
                )

                Spacer(modifier = Modifier.height(5.dp))

                Image(
                    painter = painterResource(photo.imagePhoto),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxSize()
                        .height(200.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Описание:",
                    style = MaterialTheme.typography.displayMedium,
                    fontSize = 15.sp
                    )

                if (expanded) {
                    PhotoAnimate(
                        photo.descriptionPhoto,
                        modifier = Modifier.padding(
                            start = 2.dp,
                            top = 8.dp,
                            bottom = 16.dp,
                            end = 17.dp
                        )
                    )
                }

            }

        }
    }

@Composable
fun PhotoAnimate(
    @StringRes descriptionPhoto: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(descriptionPhoto),
        modifier = modifier,
        fontSize = 15.sp
    )
}

@Preview
@Composable
fun PhotoPreview(){
    PhotoCard()
}