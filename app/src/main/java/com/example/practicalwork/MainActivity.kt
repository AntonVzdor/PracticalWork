package com.example.practicalwork

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicalwork.ui.theme.PracticalWorkTheme
import com.example.practicalwork.ui.theme.md_theme_light_error

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    PhotoAlbum()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PhotoAlbum() {
    Scaffold(
        modifier = Modifier
            .background(md_theme_light_error)
            .fillMaxSize(),
        topBar = { TopBarApp() }
    ) {
        PhotoCard(contentPadding = it)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        PhotoAlbum()
    }
}

@Preview
@Composable
fun WoofDarkThemePreview() {
    PracticalWorkTheme(darkTheme = true) {
        PhotoAlbum()
    }
}