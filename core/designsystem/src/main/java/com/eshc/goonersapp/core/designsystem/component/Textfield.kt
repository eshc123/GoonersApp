package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun GnrTextFiled(
    modifier: Modifier = Modifier,
    message : String,
    onValueChange : (String) -> Unit,
    placeholder : String = ""
) {
    BasicTextField(
        modifier = modifier,
        value = message,
        maxLines = 1,
        textStyle = MaterialTheme.typography.bodyMedium,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .background(Color(0xFFF1F1F1), CircleShape)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if(message.isBlank()){
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