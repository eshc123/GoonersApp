package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun GnrTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = ColorFF10358A,
    contentColor: Color = ColorFFFFFFFF,
    round: Dp = 15.dp,
    contentPaddingValues : PaddingValues = PaddingValues(vertical = 10.dp,)
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = containerColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(round),
        contentPadding = contentPaddingValues
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = GnrTypography.heading2SemiBold,
            textAlign = TextAlign.Center
        )
    }
}