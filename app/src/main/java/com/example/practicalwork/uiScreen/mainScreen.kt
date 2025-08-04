package com.example.practicalwork.uiScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreenApp(){

    var query by remember { mutableStateOf("") }

    Column {
        TopBarMainScreen()

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Enter departure airport") },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn {

        }
    }
}

@Preview
@Composable
fun PreviewScreen(){
    MainScreenApp()
}