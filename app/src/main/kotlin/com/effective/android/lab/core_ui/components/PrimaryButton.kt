package com.effective.android.lab.core_ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.effective.android.lab.R
import com.effective.android.lab.ui.theme.EffectiveAndroidLabTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
            disabledElevation = 0.dp,
        ),
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
    ) {
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.labelMedium.copy(
                MaterialTheme.colorScheme.background,
            ),
        )
    }
}

@Preview(
    name = "Primary button preview",
    group = "Common components",
    showBackground = true,
)
@Composable
fun PrimaryButtonPreview() {
    EffectiveAndroidLabTheme {
        PrimaryButton(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp,
                )
                .width(260.dp),
            text = R.string.install,
            onClick = { /*TODO*/ },
        )
    }
}