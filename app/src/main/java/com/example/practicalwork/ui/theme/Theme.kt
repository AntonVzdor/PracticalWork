package com.example.practicalwork.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = MoscowRed,
    secondary = LightGray,
    tertiary = Gold,
    background = Black,
    surface = DarkGray
)

private val LightColorScheme = lightColorScheme(
    primary = MoscowRed,
    secondary = DarkGray,
    tertiary = Gold,
    background = White,
    surface = LightGray
)

@Composable
fun PracticalWorkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}