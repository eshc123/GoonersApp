package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.GnrNavigationBarItem(
    selected : Boolean,
    onClick : () -> Unit,
    label: @Composable () -> Unit,
    icon : @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
){
    BottomNavigationItem(
        modifier = modifier,
        selected = selected,
        icon = if (selected) selectedIcon else icon,
        onClick = onClick,
        label = label
    )

}

@Composable
fun GnrNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = Color.White,
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = containerColor,
        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
        tonalElevation = tonalElevation,
        border = BorderStroke(1.dp, Color(0xFFF0F0F0)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(windowInsets)
                .height(56.dp)
                .selectableGroup(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = content,
            verticalAlignment = Alignment.CenterVertically
        )
    }
}