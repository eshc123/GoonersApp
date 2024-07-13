package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF

@Composable
fun GnrTextFiled(
    text : String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder : String = "",
    backgroundColor : Color = ColorFFFFFFFF,
    shape : Shape = CircleShape,
    borderStroke: BorderStroke = BorderStroke(1.dp, ColorFFDCDCDC),
    enabled : Boolean = true
) {
    BasicTextField(
        modifier = modifier,
        value = text,
        maxLines = 1,
        enabled = enabled,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = if(enabled) Color.Black else Color.Gray
        ),
        onValueChange = {
            onValueChange(it)
        },
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .border(borderStroke, shape)
                    .background(backgroundColor)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if(text.isBlank()){
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }

        }
    )
}