package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun GnrTextFiled(
    modifier: Modifier = Modifier,
    message : String,
    onValueChange : (String) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = message,
        maxLines = 1,
        textStyle = TextStyle(
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
        ),
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .background(Color(0xFFF1F1F1), CircleShape)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                innerTextField()
            }

        }
    )
}