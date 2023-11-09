package com.effective.android.lab.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    small = RoundedCornerShape(size = 12.dp),
    medium = RoundedCornerShape(size = 16.dp),
    large = RoundedCornerShape(size = 20.dp),
    extraLarge = RoundedCornerShape(size = 32.dp),
)

abstract  class Dimensions {
    companion object {
        const val EXTRA_SMALL = 10
        const val TINY_SMALL = 14
        const val SMALL = 20
        const val MEDIUM_SMALL = 24
        const val MEDIUM = 32
        const val LARGE = 46
        const val EXTRA_LARGE = 90
    }
}
