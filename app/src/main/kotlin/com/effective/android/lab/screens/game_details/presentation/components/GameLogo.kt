package com.effective.android.lab.screens.game_details.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun GameLogo(
    modifier: Modifier = Modifier,
    @DrawableRes logo: Int,
) {
    Surface(
        modifier = modifier,
        shadowElevation = 30.dp,
        color = MaterialTheme.colorScheme.tertiary,
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primaryContainer,
        ),
    ) {
        Image(
            modifier = Modifier.padding(16.dp),
            painter = painterResource(id = logo),
            contentDescription = stringResource(R.string.dota_2_logo),
        )
    }
}

@Preview(
    name = "Game logo preview",
    group = "Game details components",
    showBackground = true,
)
@Composable
fun GameLogoPreview() {
    EffectiveAndroidLabTheme {
        GameLogo(
            modifier = Modifier.padding(20.dp),
            logo = R.drawable.dota_2_logo,
        )
    }
}