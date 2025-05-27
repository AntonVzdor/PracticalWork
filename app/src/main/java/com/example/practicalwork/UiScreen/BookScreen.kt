package com.example.practicalwork.UiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.R

@Composable
fun BoolList(){

    Column {
        CenterTopBar()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(10) { item ->
                ItemBoolList()
            }
        }
    }
}

@Composable
fun ItemBoolList(){
    Image(
        painter = painterResource(R.drawable.ic_broken_image),
        contentDescription = "no",
        modifier = Modifier
            .fillMaxSize()
            .size(200.dp)
    )
}

@Preview
@Composable
fun PreviewBoolList(){
    ItemBoolList()
}