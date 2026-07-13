package com.sony.productbrowser.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme) {
            AppDarkColorScheme
        } else {
            AppLightColorScheme
        },
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}