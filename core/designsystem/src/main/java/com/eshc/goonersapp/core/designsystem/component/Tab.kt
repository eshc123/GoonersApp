package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.ColorFF10358A
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography


@Composable
fun GnrTabItem(
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
            modifier = Modifier.padding(bottom = 8.dp),
            text = tabTitle,
            style = GnrTypography.body1SemiBold,
            color = if (isSelected) ColorFF10358A else ColorFF9E9E9E,
        )
        if (isSelected)
            HorizontalDivider(
                modifier = Modifier,
                color = ColorFF10358A,
                thickness = 2.dp
            )
    }
}