package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title : String,
    content : @Composable () -> Unit
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp).wrapContentHeight().weight(1f),
            text = title,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
        )
        content()
    }
}