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
import androidx.compose.ui.unit.dp

@Composable
fun ChatMessageCard(
    text : String
) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .widthIn(max = 200.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF151D2D)
        )
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = text,
            color = Color.White
        )
    }
}
