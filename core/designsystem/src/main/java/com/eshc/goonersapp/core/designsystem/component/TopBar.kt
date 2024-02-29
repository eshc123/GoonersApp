package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.iconpack.IcFootballClub
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun TopLevelTopBar(
    modifier: Modifier = Modifier,
    title : String,
    content : @Composable () -> Unit
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight().weight(1f),
            text = title,
            fontFamily = pretendard,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
        )
        content()
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title : String,
    content : @Composable () -> Unit = {}
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier= Modifier.padding(start = 8.dp,end = 8.dp).size(24.dp)
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight().weight(1f),
            text = title,
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            fontSize = 24.sp,
        )
        content()
    }
}