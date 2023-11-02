package com.effective.android.lab.screens.game_details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.screens.game_details.presentation.models.ReviewMessageItemUI
import java.text.SimpleDateFormat
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
                modifier = Modifier.size(36.dp),
                painter = painterResource(reviewMessage.user.photo),
                contentDescription = stringResource(R.string.review_message_item)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${stringResource(reviewMessage.user.firstName)} " +
                            stringResource(reviewMessage.user.lastName),
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.primary,
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = dateFormatter.format(reviewMessage.date),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = .4F),
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = stringResource(id = reviewMessage.review),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.secondary,
            ),
        )
    }
}
