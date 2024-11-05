package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.practicalwork.ui.SportsApp
import com.example.practicalwork.ui.theme.PracticalWorkTheme

/**
 * Activity for Sports app
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PracticalWorkTheme {
                Surface {
                    SportsApp()
                }
            }
        }
    }
}
