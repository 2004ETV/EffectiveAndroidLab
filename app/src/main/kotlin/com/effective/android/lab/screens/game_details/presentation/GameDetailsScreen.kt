package com.effective.android.lab.screens.game_details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.core.extensions.drawGlow
import com.effective.android.lab.core_ui.components.PrimaryButton
import com.effective.android.lab.screens.game_details.presentation.components.GameImageItem
import com.effective.android.lab.screens.game_details.presentation.components.GameLogo
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun GameDetailsScreen() {
    val configuration = LocalConfiguration.current
    val gameImages = listOf(
        R.drawable.first_image,
        R.drawable.second_image,
    )
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = (configuration.screenHeightDp / 2.2).dp),
            painter = painterResource(id = R.drawable.dota_2_cover),
            contentDescription = stringResource(R.string.dota_2_cover_description),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .height(((configuration.screenHeightDp / 1.42) + 40).dp)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .height((configuration.screenHeightDp / 1.42).dp)
                    .verticalScroll(scrollState)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp,
                        ),
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = RoundedCornerShape(
                            topStart = 32.dp,
                            topEnd = 32.dp,
                        ),
                    ),
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    text = stringResource(id = R.string.dota_2_description),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7F),
                    ),
                )
                Spacer(modifier = Modifier.height(46.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    items(gameImages) { item ->
                        GameImageItem(
                            modifier = Modifier
                                .height(130.dp)
                                .clip(shape = MaterialTheme.shapes.medium),
                            image = item,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(46.dp))
                PrimaryButton(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .drawWithContent {
                            drawContent()
                            drawGlow(radius = 16.dp)
                        },
                    text = R.string.install,
                    onClick = { /*TODO*/ },
                )
                Spacer(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .height(24.dp),
                )
            }
            GameLogo(
                modifier = Modifier
                    .padding(start = 22.dp)
                    .align(Alignment.TopStart),
                logo = R.drawable.dota_2_logo,
            )
        }
        Box(
            modifier = Modifier
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
}

@Preview(
    name = "Game details screen preview (Small)",
    group = "Screens preview",
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_3,
)
@Composable
fun GameDetailsScreenPreviewSmall() {
    EffectiveAndroidLabTheme {
        GameDetailsScreen()
    }
}

@Preview(
    name = "Game details screen preview (Large)",
    group = "Screens preview",
    showSystemUi = true,
    showBackground = true,
    device = Devices.PIXEL_4_XL,
)
@Composable
fun GameDetailsScreenPreviewLarge() {
    EffectiveAndroidLabTheme {
        GameDetailsScreen()
    }
}