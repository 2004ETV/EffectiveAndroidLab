package com.effective.android.lab

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.effective.android.lab.screens.game_details.presentation.GameDetailsScreen
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT,
            ),
        )
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveAndroidLabTheme {
                GameDetailsScreen()
            }
        }
    }
}