package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicalwork.model.DataSource
import com.example.practicalwork.ui.theme.PracticalWorkTheme

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

@Composable
fun PhotoAlbum(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        val photos = DataSource.photo
        PhotoCard(photos = photos, contentPadding = it)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        PhotoAlbum()
    }
}