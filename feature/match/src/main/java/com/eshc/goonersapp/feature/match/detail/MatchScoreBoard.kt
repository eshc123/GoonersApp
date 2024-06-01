package com.eshc.goonersapp.feature.match.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.core.domain.model.match.getScoreHistoryList
import com.eshc.goonersapp.feature.match.model.MatchUiModel

@Composable
fun LazyItemScope.MatchScoreBoard(
    match: MatchUiModel,
    matchDetailList: List<MatchDetail>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 20.dp
            )
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
        content = {
            MatchScoredHistory(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End,
                matchScoreHistoryList = matchDetailList.getScoreHistoryList(
                    match.homeTeamId
                )
            )
            Icon(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = com.eshc.goonersapp.core.designsystem.R.drawable.ic_ball),
                contentDescription = "ball"
            )
            MatchScoredHistory(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start,
                matchScoreHistoryList = matchDetailList.getScoreHistoryList(
                    match.awayTeamId
                )
            )
        }
    )
}