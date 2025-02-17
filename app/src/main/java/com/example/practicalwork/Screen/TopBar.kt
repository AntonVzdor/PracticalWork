package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarApp(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    isShowingListPage: Boolean
){
    TopAppBar(
        title = {
            Text("MyCity")
        },
        navigationIcon = if (!isShowingListPage) {
            {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            { Box {} }
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun TopBarAppPreview(){
    TopBarApp(
        onBackClick = {},
        isShowingListPage = false
    )
}