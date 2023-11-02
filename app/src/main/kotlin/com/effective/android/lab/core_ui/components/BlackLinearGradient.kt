package com.effective.android.lab.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun BlackLinearGradient(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(130.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.tertiary,
                        MaterialTheme.colorScheme.tertiary.copy(alpha = 0F),
                    ),
                )
            ),
    )
}

@Preview(
    name = "Black linear gradient preview",
    group = "Common components",
    showBackground = true,
)
@Composable
fun BlackLinearGradientPreview() {
    EffectiveAndroidLabTheme {
        BlackLinearGradient(modifier = Modifier.padding(20.dp))
    }
}