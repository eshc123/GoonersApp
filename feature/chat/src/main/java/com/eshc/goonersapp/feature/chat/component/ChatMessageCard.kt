package com.eshc.goonersapp.feature.chat.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun ChatMessageCard(
    text : String,
    isMine : Boolean = true
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .widthIn(max = 200.dp)
            .padding( vertical = 3.dp),
        shape = RoundedCornerShape(
            bottomEnd = 12.dp,
            bottomStart = 12.dp,
            topStart = if(isMine) 12.dp else 0.dp,
            topEnd = if(isMine) 0.dp else 12.dp
        ) ,
        colors = CardDefaults.cardColors(
            containerColor =
            if(isMine) Color(0xFF151D2D) else Color(0xFFF8EFEF)
        )
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = text,
            fontFamily = pretendard,
            fontWeight = FontWeight.Normal,
            color = if(isMine)  Color.White else Color.Black
        )
    }
}
