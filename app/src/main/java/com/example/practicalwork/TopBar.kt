package com.example.practicalwork

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = { Text(
            text = "Фотоальбом",
            fontSize = 25.sp,
            style = MaterialTheme.typography.labelLarge) },
        modifier = modifier
            .shadow(10.dp)
    )
}