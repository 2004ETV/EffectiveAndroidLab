package com.effective.android.lab.core.extensions

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import com.effective.android.lab.ui.theme.sandstorm

fun ContentDrawScope.drawGlow(
    radius: Dp,
    color: Color = sandstorm,
) {
    this.drawIntoCanvas {
        val paint = Paint().apply {
                style = PaintingStyle.Stroke
                strokeWidth = 30f
            }

        val frameworkPaint =
            paint.asFrameworkPaint()

        this.drawIntoCanvas {
            frameworkPaint.color = color.copy(alpha = 0f).toArgb()
            frameworkPaint.setShadowLayer(
                radius.toPx(),
                0f,
                0f,
                color.copy(alpha = .22F).toArgb()
            )
            it.drawRoundRect(
                left = 0f,
                right = size.width,
                bottom = size.height,
                top = 0f,
                radiusY = radius.toPx(),
                radiusX = radius.toPx(),
                paint = paint
            )
        }
    }
}