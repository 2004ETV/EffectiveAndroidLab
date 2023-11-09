package com.effective.android.lab.screens.game_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.screens.game_details.presentation.models.ReviewMessageItemUI
import com.effective.android.lab.screens.game_details.presentation.models.UserItemUI
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ReviewMessageItem(
    modifier: Modifier = Modifier,
    reviewMessage: ReviewMessageItemUI,
) {
    val dateFormatter = SimpleDateFormat("MMMM dd, yyyy", Locale.ROOT)

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape),
                painter = painterResource(reviewMessage.user.photo),
                contentDescription = stringResource(R.string.review_message_item)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${stringResource(reviewMessage.user.firstName)} " +
                            stringResource(reviewMessage.user.lastName),
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelSmall,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = dateFormatter.format(reviewMessage.date),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = .4F),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = stringResource(id = reviewMessage.review),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(
    name = "Review message item preview",
    group = "Game details screen components",
    showBackground = true,
    backgroundColor = 2,
)
@Composable
fun ReviewMessageItemPreview() {
    EffectiveAndroidLabTheme {
        ReviewMessageItem(
            modifier = Modifier.padding(20.dp),
            reviewMessage = ReviewMessageItemUI(
                user = UserItemUI(
                    photo = R.drawable.first_user,
                    firstName = R.string.first_user_first_name,
                    lastName = R.string.first_user_last_name
                ),
                date = Date(1550134475000),
                review = R.string.first_review,
            ),
        )
    }
}