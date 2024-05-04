package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.designsystem.component.GnrElevatedCard
import com.eshc.goonersapp.core.designsystem.component.LargeDropdownMenu
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE9343C
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFECD44
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun StatScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        GnrDropdownMenu(
            modifier = Modifier.padding(start = 14.dp,end = 14.dp, top = 26.dp),
            label = "season",
            selectedIndex = 0,
            items = listOf("2023-2024", "2022-2023"),
            onItemSelected = { index, item ->
                //TODO
            }
        )

        TotalStatCard()


    }
}

@Composable
fun TotalStatCard(
    modifier: Modifier = Modifier,
) {
    GnrElevatedCard(
        modifier = modifier.padding(vertical = 20.dp, horizontal = 14.dp),
        radius = 15.dp,
        colors = CardDefaults.elevatedCardColors(
            containerColor = ColorFFFFFFFF
        )
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                StatContent(
                    title = "Matches Played",
                    description = "9"
                )
                StatContent(
                    title = "Goals",
                    description = "10"
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 18.dp),
                color = ColorFFDCDCDC,
                thickness = 1.dp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                StatContentWithColorChip(
                    title = "Yellow Cards",
                    description = "0",
                    color = ColorFFFECD44
                )
                StatContentWithColorChip(
                    title = "Red Cards",
                    description = "0",
                    color = ColorFFE9343C
                )
            }
        }

    }
}

@Composable
fun RowScope.StatContent(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .weight(1f),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = GnrTypography.body2Regular,
            color = ColorFF777777
        )
        Text(
            text = description,
            style = GnrTypography.heading1SemiBold,
            color = ColorFF000000
        )
    }
}

@Composable
fun RowScope.StatContentWithColorChip(
    title: String,
    description: String,
    color: Color
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .weight(1f),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = GnrTypography.body2Regular,
            color = ColorFF777777
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .width(13.dp)
                    .height(20.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(color)
            )
            Text(
                text = description,
                style = GnrTypography.heading1SemiBold,
                color = ColorFF000000
            )
        }

    }
}
