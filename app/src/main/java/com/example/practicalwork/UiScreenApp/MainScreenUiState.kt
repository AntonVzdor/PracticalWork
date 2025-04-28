package com.example.practicalwork.UiScreenApp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//вертикальный список
@Composable
fun ListOfAmphibians(){
    Text(text = "Работа началась")
}

//элемент списка
@Composable
fun ItemOfAmphibians(){

}

@Preview
@Composable
fun PreviewListOfAmphibians(){
    ListOfAmphibians()
}