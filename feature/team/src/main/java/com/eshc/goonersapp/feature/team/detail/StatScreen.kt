package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@Composable
fun StatScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedCard(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            border = BorderStroke(width = 1.dp, color = Color(0xFFF1F1F1)),
            colors = CardDefaults.outlinedCardColors(
                containerColor = Color.Transparent
            )

        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = "2023-2024",
                textAlign = TextAlign.Center,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp,
                letterSpacing = 0.1.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ){
            TotalStatCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                statType = StatType.APPEARANCES,
                18
            )
            Spacer(modifier = Modifier.width(8.dp))
            TotalStatCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                statType = StatType.GOALS,
                8
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ){
            TotalStatCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                statType = StatType.ASSISTS,
                10
            )
            Spacer(modifier = Modifier.width(8.dp))
            TotalStatCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                statType = StatType.MOTM,
                4
            )
        }


    }
}

@Composable
fun TotalStatCard(
    modifier: Modifier = Modifier,
    statType: StatType,
    count : Int
) {
    OutlinedCard(
        modifier = modifier,
        border = BorderStroke(width = 1.dp, color = Color(0xFFF1F1F1)),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent
        )

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = statType.name,
                textAlign = TextAlign.Center,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp,
                letterSpacing = 0.1.sp
            )
            Text(
                text = "$count",
                textAlign = TextAlign.Center,
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 60.sp,
                letterSpacing = 0.1.sp
            )
        }

    }
}

enum class StatType {
    APPEARANCES, GOALS, ASSISTS,MOTM
}