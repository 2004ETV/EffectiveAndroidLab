package com.effective.android.lab.ui.theme

import android.app.Activity
import android.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.ui.graphics.Color as Colors

private val DarkColorScheme = darkColorScheme(
    primary = aliceBlue,
    onPrimary = sandstorm,
    primaryContainer = darkGunmetal,
    secondary = metallicSilver,
    onSecondary = pictonBlue,
    tertiary = Colors.Black,
    background = richBlack,
)

private val LightColorScheme = lightColorScheme(
    primary = aliceBlue,
    onPrimary = sandstorm,
    primaryContainer = darkGunmetal,
    secondary = metallicSilver,
    onSecondary = pictonBlue,
    tertiary = Colors.Black,
    background = richBlack,
)

@Composable
fun EffectiveAndroidLabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.TRANSPARENT
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = shapes,
    )
}