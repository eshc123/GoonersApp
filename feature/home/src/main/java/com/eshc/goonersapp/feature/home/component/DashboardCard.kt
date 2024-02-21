package com.eshc.goonersapp.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
fun DashboardCard() {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF151D2D))
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "EPL",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 14.sp,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(vertical = 4.dp, horizontal = 8.dp)
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
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
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
            modifier = Modifier.wrapContentHeight().weight(1f),
            text = "$points",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier.wrapContentHeight().weight(1f),
            text = "$wins",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier.wrapContentHeight().weight(1f),
            text = "$draws",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier.wrapContentHeight().weight(1f),
            text = "$losses",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
        Text(
            modifier = Modifier.wrapContentHeight().weight(1f),
            text = "${if(goalDiff > 0)"+" else ""}${goalDiff}",
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            fontSize = 13.sp,
        )
    }
}