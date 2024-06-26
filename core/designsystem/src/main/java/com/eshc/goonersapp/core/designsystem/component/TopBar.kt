package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.iconpack.IcIosArrowBack
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun GnrTopLevelTopBar(
    title : String,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight().weight(1f),
            text = title,
            style = GnrTypography.heading2SemiBold,
            color = Color.Black,
        )
        content()
    }
}

@Composable
fun GnrTopBar(
    title : String,
    onBackIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit = {}
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = IconPack.IcIosArrowBack,
            contentDescription = null,
            modifier= Modifier
                .padding(start = 8.dp,end = 8.dp)
                .size(24.dp)
                .clickable(onClick = onBackIconClick)
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp).wrapContentHeight().weight(1f),
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Black,
        )
        content()
    }
}