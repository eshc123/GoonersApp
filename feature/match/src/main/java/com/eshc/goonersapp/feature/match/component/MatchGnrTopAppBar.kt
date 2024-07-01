package com.eshc.goonersapp.feature.match.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrTopLevelTopBar
import com.eshc.goonersapp.core.designsystem.iconpack.IcGrid
import com.eshc.goonersapp.core.designsystem.iconpack.IcList
import com.eshc.goonersapp.core.designsystem.iconpack.IcPeople
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.feature.match.CalendarType

@Composable
fun GnrMatchTopAppBar(
    calendarType: CalendarType,
    onClickUser: () -> Unit,
    onClickViewType: () -> Unit
) {
    GnrTopLevelTopBar(
        modifier = Modifier.padding(horizontal = 15.dp),
        title = "Match"
    ) {
        Icon(
            imageVector = when(calendarType) {
                CalendarType.Grid -> IconPack.IcList
                CalendarType.List -> IconPack.IcGrid
            },
            contentDescription = "Icon Calendar View Type",
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
                .clickable(onClick = onClickViewType),
            tint = ColorFF777777
        )
        Icon(
            imageVector = IconPack.IcPeople,
            contentDescription = "Icon User",
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
                .clickable(onClick = onClickUser),
            tint = ColorFF777777
        )
    }
}