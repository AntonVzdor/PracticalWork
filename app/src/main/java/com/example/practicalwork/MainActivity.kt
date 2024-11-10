package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicalwork.ui.theme.PracticalWorkTheme
import com.example.practicalwork.uiFile.SportsApp

/**
 * Activity for Sports app
 */
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PracticalWorkTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass( this )
                    SportsApp(
                        windowSize = windowSize.widthSizeClass,
                        onBackPressed = {finish()}
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SportAppPreviewCompact(){
    PracticalWorkTheme {
        SportsApp(
            windowSize = WindowWidthSizeClass.Compact,
            onBackPressed = {}
        )
    }
}

@Preview
@Composable
fun SportAppPreviewMedium(){
    PracticalWorkTheme {
        SportsApp(
            windowSize = WindowWidthSizeClass.Medium,
            onBackPressed = {}
        )
    }
}

@Preview
@Composable
fun SportAppPreviewExpanded(){
    PracticalWorkTheme {
        SportsApp(
            windowSize = WindowWidthSizeClass.Expanded,
            onBackPressed = {}
        )
    }
}