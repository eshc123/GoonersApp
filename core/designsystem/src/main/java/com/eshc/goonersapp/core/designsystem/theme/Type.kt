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

object GnrTypography {
    val heading1Bold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )

    val heading1SemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    )

    val heading1Medium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    )

    val heading1Regular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )

    val heading2Bold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    val heading2SemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    )

    val heading2Medium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )

    val heading2Regular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )

    val subtitleBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    val subtitleSemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    )

    val subtitleMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )

    val subtitleRegular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )

    val body1Bold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

    val body1SemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )

    val body1Medium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )

    val body1Regular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    
    val body2Bold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )

    val body2SemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )

    val body2Medium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )

    val body2Regular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

    val descriptionBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    )

    val descriptionSemiBold = DefaultTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp
    )

    val descriptionMedium = DefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )

    val descriptionRegular = DefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
}