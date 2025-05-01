package com.example.practicalwork.UiScreenApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.R

//вертикальный список
@Composable
fun ListOfAmphibians() {
    Scaffold(
        topBar = { TopBarOfAmphibians() }
    ) { innerPadding ->
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(6) {
            ItemOfAmphibians()
        }
    }
}
}

//элемент списка
@Composable
fun ItemOfAmphibians(
    modifier: Modifier = Modifier
){
    Box(modifier = modifier
        .fillMaxSize()
        .padding(all = 15.dp)
        .background(color = colorResource(R.color.teal_200))
        ){
        Column {
            Text(
                text = "Name"
            )
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "NO"
            )
            Text(
                text = "description"
            )
        }
    }
}

@Preview
@Composable
fun PreviewListOfAmphibians(){
    ListOfAmphibians()
}

@Preview
@Composable
fun PreviewItemOfAmphibians(){
    ItemOfAmphibians()
}