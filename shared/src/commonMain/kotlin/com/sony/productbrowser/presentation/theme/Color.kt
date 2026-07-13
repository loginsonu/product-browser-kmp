package com.sony.productbrowser.presentation.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF1976D2),
    secondary = Color(0xFF03A9F4),
    tertiary = Color(0xFF009688)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF90CAF9),
    secondary = Color(0xFF4FC3F7),
    tertiary = Color(0xFF80CBC4)
)

internal val AppLightColorScheme = LightColors
internal val AppDarkColorScheme = DarkColors