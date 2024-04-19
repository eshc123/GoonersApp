package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.designsystem.component.GNRElevatedCard
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun DashboardCard(modifier: Modifier = Modifier) {
    GNRElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        radius = 4.dp,
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 12.dp)
                .padding(top = 12.dp, bottom = 5.dp),
            content =  {
                LeagueDashboardTitle()
                Spacer(modifier = Modifier.size(5.dp))
                Divider(modifier = modifier.fillMaxWidth(), color = ColorFFDCDCDC, thickness = 1.dp)
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 4.dp, horizontal = 12.dp)
        ){
            LeagueDashboardItem(
                1,"ARS",40,13,3,2,22
            )
            LeagueDashboardItem(
                2,"LIV",33,10,3,2,16
            )
            LeagueDashboardItem(
                3,"MCI",30,9,3,2,12
            )
            LeagueDashboardItem(
                4,"AVL",29,8,3,2,10
            )
        }
    }
}

@Composable
fun LeagueDashboardTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "EPL",
            color = ColorFF181818,
            style = GnrTypography.body1Medium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            content =  {
                Text(
                    text = "All",
                    color = ColorFF9E9E9E,
                    style = GnrTypography.descriptionMedium
                )
                Spacer(modifier = modifier.size(5.dp))
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "All",
                    tint = ColorFF9E9E9E
                )
            }
        )
    }
}

@Composable
fun LeagueDashboardItem(
    rank : Int,
    team : String,
    points : Int,
    wins : Int,
    draws : Int,
    losses : Int,
    goalDiff : Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.width(74.dp),
            text = "${rank}. ${team}",
            fontFamily = pretendard,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            fontSize = 14.sp,
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = "$points",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = "$wins",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = "$draws",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = "$losses",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = "${if(goalDiff > 0)"+" else ""}${goalDiff}",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
    }
}