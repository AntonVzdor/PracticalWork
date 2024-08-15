package com.example.practicalwork

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = { Text(
            text = "Фотоальбом",
            style = MaterialTheme.typography.bodyMedium,) },
        modifier = modifier)
}