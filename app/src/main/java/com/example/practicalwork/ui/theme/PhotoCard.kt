package com.example.practicalwork.ui.theme

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.practicalwork.model.PhotoAlbumData

@Composable
fun PhotoCardItem(photo: PhotoAlbumData, modifier: Modifier  = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
    ) {

    }
}