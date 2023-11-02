package com.effective.android.lab.core_ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.core.extensions.drawRating
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    spaceBetween: Dp = 4.dp
) {

    val image = ImageBitmap.imageResource(id = R.drawable.star)
    val imageFull = ImageBitmap.imageResource(id = R.drawable.star_full)

    val totalCount = 5

    val height = LocalDensity.current.run { image.height.toDp() }
    val width = LocalDensity.current.run { image.width.toDp() }
    val space = LocalDensity.current.run { spaceBetween.toPx() }
    val totalWidth = width * totalCount + spaceBetween * (totalCount - 1)


    Box(
        modifier
            .width(totalWidth)
            .height(height)
            .drawBehind {
                drawRating(rating, image, imageFull, space)
            }
    )
}

@Preview(
    name = "Rating bar preview",
    group = "Common components",
    showBackground = true,
)
@Composable
fun RatingBarPreview() {
    EffectiveAndroidLabTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            RatingBar(rating = 1.25F)
            RatingBar(rating = 2.5F)
            RatingBar(rating = 3.75F)
            RatingBar(rating = 5F)
        }
    }
}