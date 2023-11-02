package com.effective.android.lab.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.effective.android.lab.R

val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_medium, weight = FontWeight.W500),
)

val SKModernistFontFamily = FontFamily(
    listOf(
        Font(R.font.sk_modernist_bold, weight = FontWeight.W700),
        Font(R.font.sk_modernist_regular, weight = FontWeight.W400),
    )
)

val Typography = Typography(
    labelLarge = TextStyle(
        fontFamily = SKModernistFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 48.sp,
        lineHeight = 57.6.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = SKModernistFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        lineHeight = 26.sp,
        letterSpacing = .5.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = SKModernistFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        letterSpacing = .6.sp,
        lineHeight = 19.2.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = SKModernistFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = 0.sp,
        lineHeight = 19.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = MontserratFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
    ),
)