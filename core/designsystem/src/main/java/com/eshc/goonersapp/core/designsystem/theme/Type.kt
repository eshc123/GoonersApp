package com.eshc.goonersapp.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

private val DefaultTextStyle = TextStyle(
    fontFamily = poppins,
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    ),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

val TypographyPoppins = Typography(
    displayLarge = DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),
    displayMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall =DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
    ),

    headlineLarge = DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),

    titleLarge = DefaultTextStyle.copy(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleSmall = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    bodyLarge = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    bodySmall = DefaultTextStyle.copy(
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),

    labelLarge = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    labelSmall = DefaultTextStyle.copy(
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        lineHeight = 16.sp
    ),
)
