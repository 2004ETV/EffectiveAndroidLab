package com.effective.android.lab.screens.game_details.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun GameImageItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = image),
        contentDescription = stringResource(id = R.string.game_image)
    )
}

@Preview(
    name = "Game image item preview",
    group = "Game details screen components",
    showBackground = true,
)
@Composable
fun GameImageItemPreview() {
    EffectiveAndroidLabTheme {
        GameImageItem(
            modifier = Modifier
                .height(130.dp)
                .padding(20.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            image = R.drawable.first_image,
        )
    }
}