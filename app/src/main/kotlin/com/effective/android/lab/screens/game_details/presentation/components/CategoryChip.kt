package com.effective.android.lab.screens.game_details.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun CategoryChip(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = MaterialTheme.colorScheme.onSecondary.copy(alpha = .24F),
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 5.dp,
            ),
            text = stringResource(id = label).uppercase(),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview(
    name = "Category chip preview",
    group = "Game details screen components",
    showBackground = true,
)
@Composable
fun CategoryChipPreview() {
    EffectiveAndroidLabTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
            CategoryChip(label = R.string.moba)
            CategoryChip(label = R.string.multiplayer)
            CategoryChip(label = R.string.strategy)
        }
    }
}