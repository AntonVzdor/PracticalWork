package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Utils.WindowsStateUtils

@Composable
fun AppScreen(
    onClick:(CategoryData) -> Unit,
    windowSize: WindowWidthSizeClass
){
    val contentType: WindowsStateUtils = when(windowSize) {
        WindowWidthSizeClass.Compact->{
            WindowsStateUtils.ListScreen
        }
        WindowWidthSizeClass.Medium->{
            WindowsStateUtils.ListScreen
        }
        WindowWidthSizeClass.Expanded->{
            WindowsStateUtils.ListEndDetailScreen
        }
        else ->{
            WindowsStateUtils.ListScreen
        }
    }

    Scaffold {
            innerPadding  ->
        if(contentType == WindowsStateUtils.ListScreen){
            CategoryScreen(
                modifier = Modifier,
                onClickItem = onClick,
                contentPadding = innerPadding
            )
        } else{
            CategoryScreen(
                modifier = Modifier.fillMaxSize(),
                onClickItem = onClick,
                contentPadding = innerPadding
            )
        }
    }
}