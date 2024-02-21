package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
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
fun TabItem(
    modifier: Modifier = Modifier,
    tabTitle: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onSelect()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = tabTitle,
            fontFamily = pretendard,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.Black else Color.LightGray,
            fontSize = 14.sp
        )
        if (isSelected)
            Divider(
                modifier = Modifier,
                color = Color.Black,
                thickness = 2.dp
            )
    }
}