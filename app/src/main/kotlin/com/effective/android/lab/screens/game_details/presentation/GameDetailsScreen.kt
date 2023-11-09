package com.effective.android.lab.screens.game_details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.core.extensions.drawGlow
import com.effective.android.lab.core_ui.components.BlackLinearGradient
import com.effective.android.lab.core_ui.components.PrimaryButton
import com.effective.android.lab.core_ui.components.RatingBar
import com.effective.android.lab.screens.game_details.presentation.components.CategoryChip
import com.effective.android.lab.screens.game_details.presentation.components.GameImageItem
import com.effective.android.lab.screens.game_details.presentation.components.GameLogo
import com.effective.android.lab.screens.game_details.presentation.components.ReviewMessageItem
import com.effective.android.lab.screens.game_details.presentation.models.RatingModel
import com.effective.android.lab.screens.game_details.presentation.models.ReviewMessageItemUI
import com.effective.android.lab.screens.game_details.presentation.models.UserItemUI
import com.effective.android.lab.ui.theme.Dimensions
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameDetailsScreen() {
    val configuration = LocalConfiguration.current
    val gameImages = listOf(
        R.drawable.first_image,
        R.drawable.second_image,
    )
    val ratingModel = RatingModel(
        rating = 4.5F,
        reviewsCount = R.string.reviews_count,
    )
    val reviewMessages = listOf(
        ReviewMessageItemUI(
            user = UserItemUI(
                photo = R.drawable.first_user,
                firstName = R.string.first_user_first_name,
                lastName = R.string.first_user_last_name
            ),
            date = Date(1550134475000),
            review = R.string.first_review,
        ),
        ReviewMessageItemUI(
            user = UserItemUI(
                photo = R.drawable.second_user,
                firstName = R.string.second_user_first_name,
                lastName = R.string.second_user_last_name
            ),
            date = Date(1550134475000),
            review = R.string.second_review,
        ),
    )
    val categoryChipsLabels = listOf(
        R.string.moba,
        R.string.multiplayer,
        R.string.strategy,
        )
    val scrollState = rememberScrollState()
    var isLoading by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = (configuration.screenHeightDp / 2.2).dp),
                    painter = painterResource(id = R.drawable.dota_2_cover),
                    contentDescription = stringResource(R.string.dota_2_cover_description),
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier
                        .padding(top = ((configuration.screenHeightDp / 2.4)).dp)
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = Dimensions.MEDIUM.dp,
                                topEnd = Dimensions.MEDIUM.dp,
                            ),
                        )
                        .background(
                            color = MaterialTheme.colorScheme.background,
                        )
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = RoundedCornerShape(
                                topStart = Dimensions.MEDIUM.dp,
                                topEnd = Dimensions.MEDIUM.dp,
                            ),
                        )
                        .fillMaxWidth(),
                ) {
                    Spacer(modifier = Modifier.height(Dimensions.EXTRA_LARGE.dp))
                    FlowRow(
                        modifier = Modifier
                            .padding(horizontal = Dimensions.MEDIUM_SMALL.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Dimensions.EXTRA_SMALL.dp),
                        verticalArrangement = Arrangement.spacedBy(Dimensions.EXTRA_SMALL.dp),
                    ) {
                        categoryChipsLabels.forEach { label ->
                            CategoryChip(label = label)
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimensions.MEDIUM_SMALL.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = Dimensions.MEDIUM_SMALL.dp),
                        text = stringResource(id = R.string.dota_2_description),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .7F),
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Spacer(modifier = Modifier.height(Dimensions.LARGE.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = Dimensions.MEDIUM_SMALL.dp),
                        horizontalArrangement = Arrangement.spacedBy(Dimensions.TINY_SMALL.dp),
                    ) {
                        itemsIndexed(gameImages) { index, item ->
                            GameImageItem(
                                modifier = Modifier
                                    .height(130.dp)
                                    .clip(shape = MaterialTheme.shapes.medium),
                                image = item,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimensions.LARGE.dp))
                    Text(
                        modifier = Modifier.padding(horizontal = Dimensions.MEDIUM_SMALL.dp),
                        text = stringResource(R.string.review_ratings),
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Spacer(modifier = Modifier.height(Dimensions.TINY_SMALL.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier.padding(horizontal = Dimensions.MEDIUM_SMALL.dp),
                            text = "${ratingModel.rating}",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelLarge,
                        )
                        Spacer(modifier = Modifier.width(Dimensions.MEDIUM_SMALL.dp))
                        Column(verticalArrangement = Arrangement.Center) {
                            RatingBar(rating = ratingModel.rating)
                            Spacer(modifier = Modifier.height(Dimensions.EXTRA_SMALL.dp))
                            Text(
                                text = "${stringResource(ratingModel.reviewsCount)} " +
                                        stringResource(id = R.string.reviews),
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimensions.MEDIUM.dp))
                    for ((index, item) in reviewMessages.withIndex()) {
                        ReviewMessageItem(
                            modifier = Modifier.padding(horizontal = Dimensions.MEDIUM_SMALL.dp),
                            reviewMessage = item
                        )
                        if (index != reviewMessages.size - 1) {
                            Divider(
                                modifier = Modifier.padding(Dimensions.MEDIUM_SMALL.dp),
                                color = MaterialTheme.colorScheme.primaryContainer,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(Dimensions.LARGE.dp))
                    PrimaryButton(
                        modifier = Modifier
                            .padding(horizontal = Dimensions.SMALL.dp)
                            .fillMaxWidth()
                            .drawWithContent {
                                drawContent()
                                drawGlow(radius = 16.dp)
                            },
                        content = {
                            if (isLoading) {
                                CircularProgressIndicator(modifier = Modifier.size(24.dp))
                            } else {
                                Text(
                                    text = stringResource(R.string.install),
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = MaterialTheme.typography.labelMedium,
                                )
                            }
                        },
                        onClick = {
                            isLoading = true

                            coroutineScope.launch {
                                delay(2000)
                                isLoading = false
                            }
                        },
                    )
                    Spacer(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .height(Dimensions.MEDIUM_SMALL.dp),
                    )
                }
                Row(
                    modifier = Modifier.padding(
                        top = ((configuration.screenHeightDp / 2.7)).dp,
                        start = Dimensions.MEDIUM_SMALL.dp,
                    ),
                    verticalAlignment = Alignment.Bottom,
                ) {
                    GameLogo(logo = R.drawable.dota_2_logo)
                    Spacer(modifier = Modifier.width(Dimensions.TINY_SMALL.dp))
                    Column {
                        Text(
                            text = stringResource(id = R.string.dota_2),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.labelMedium,
                        )
                        Spacer(modifier = Modifier.height(Dimensions.EXTRA_SMALL.dp))
                        Row {
                            RatingBar(rating = ratingModel.rating)
                            Spacer(modifier = Modifier.width(Dimensions.EXTRA_SMALL.dp))
                            Text(
                                text = stringResource(id = R.string.reviews_count),
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary.copy(alpha = .4F),
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimensions.EXTRA_SMALL.dp))
                    }
                }
            }
        }
        BlackLinearGradient(modifier = Modifier.align(Alignment.TopCenter))
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