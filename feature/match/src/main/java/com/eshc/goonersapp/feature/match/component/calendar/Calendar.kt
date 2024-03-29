package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.iconpack.IcGrid
import com.eshc.goonersapp.core.designsystem.iconpack.IcList
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.match.Match
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarGrid(
    height: Int,
    headerHeight: Int,
    matchList: Map<LocalDate, List<Match>>,
    calendarMonthListState: List<CalendarDates>,
    pagerState : PagerState,
    onSelectDate: (LocalDate) -> Unit,
    onChangeCalendarType : () -> Unit,
    onClickDetail: (Match) -> Unit
) {

    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight.dp)
                .padding(horizontal = 8.dp),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = calendarMonthListState[pagerState.currentPage].currentMonth.format(
                    DateTimeFormatter.ofPattern(
                        "yyyy.MM"
                    )
                ),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Icon(
                imageVector =IconPack.IcList,
                contentDescription = null,
                modifier= Modifier
                    .align(Alignment.CenterEnd)
                    .padding(8.dp)
                    .size(24.dp)
                    .clickable {
                        onChangeCalendarType()
                    }
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT").forEach {
                    CalendarDayItem(it, 24)
                }
            }
            HorizontalPager(state = pagerState) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    for (i in 0 until calendarMonthListState[it].getAllDates().size / 7) {
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceAround,
                        ) {
                            calendarMonthListState[it].getAllDates()
                                .chunked(7)[i].forEachIndexed { index, localDate ->
                                if (calendarMonthListState[it].isCurDates(i * 7 + index))
                                    CalendarItem(
                                        localDate,
                                        (height - headerHeight) / 7,
                                        matchList
                                    ) {
                                        onClickDetail(it)
                                    }
                                else {
                                    FaintCalendarItem(localDate, (height - headerHeight) / 7)
                                }
                            }
                        }
                    }
                }
            }
//            LazyRow(
//                modifier = Modifier.fillMaxSize(),
//                state = listState,
//                flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
//            ) {
//                items(12) {
//
//
//                }
//
//            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarList(
    season : String,
    headerHeight :Int,
    matchList: Map<String, List<Match>>,
    onChangeCalendarType : () -> Unit,
    onClickDetail : (Match) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight.dp)
                .padding(horizontal = 8.dp),
        ){
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = season,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
            Icon(
                imageVector =IconPack.IcGrid,
                contentDescription = null,
                modifier= Modifier
                    .align(Alignment.CenterEnd)
                    .padding(8.dp)
                    .size(24.dp)
                    .clickable {
                        onChangeCalendarType()
                    }
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            matchList.forEach { (yearAndMonth, matches) ->
                item {
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = yearAndMonth,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                }
                items(matches){
                    CalendarListItem(
                        match = it,
                        onClickDetail = onClickDetail
                    )
                }
            }

        }
    }

}

@Composable
fun CalendarListItem(
    match: Match,
    onClickDetail: (Match) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClickDetail(match)
            }
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = DateUtil.getYearAndMonthAndDateAndTimeString(match.matchDate),
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            letterSpacing = 0.1.sp
        )
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier.size(32.dp),
                model = match.homeTeamImageUrl,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = if(match.isFinished) "${match.homeScore} : ${match.awayScore}" else "  vs  ",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                letterSpacing = 0.1.sp
            )
            AsyncImage(
                modifier = Modifier.size(32.dp),
                model = match.awayTeamImageUrl,
                contentDescription = null
            )
        }
        ImageCard(backgroundColor = Color(0xFF151D2D)) {
            AsyncImage(
                model = "https://www.arsenal.com/sites/default/files/styles/small/public/logos/comp_8.png?auto=webp&itok=EBszNKBn",
                contentDescription = null
            )
        }
    }
}

@Composable
fun RowScope.CalendarDayItem(
    text: String,
    height: Int
) {
    Text(
        modifier = Modifier
            .padding(bottom = 6.dp)
            .height(height.dp)
            .weight(1f),
        text = text,
        color = if (text == "SUN" || text == "SAT") Color.Red else Color.Gray,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RowScope.CalendarItem(
    localDate: LocalDate,
    height: Int,
    matchList: Map<LocalDate, List<Match>>,
    onClickDetail: (Match) -> Unit
) {
    Column(
        modifier = Modifier
            .height(height.dp)
            .weight(1f)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                if (matchList.containsKey(localDate)) {
                    matchList[localDate]
                        ?.firstOrNull()
                        ?.let { match ->
                            onClickDetail(match)
                        }
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = localDate.dayOfMonth.toString(),
            color = if (localDate.dayOfWeek in setOf(
                    DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
                )
            ) Color.Red else Color.Black,
            style = MaterialTheme.typography.labelLarge,
        )
        if (matchList.containsKey(localDate)) {
            matchList[localDate]?.firstOrNull()?.let { match ->
                AsyncImage(
                    modifier = Modifier.size(24.dp),
                    model = if (match.homeTeamName == "Arsenal") match.awayTeamImageUrl else match.homeTeamImageUrl,
                    contentDescription = null
                )
                if (match.isFinished) {
                    Text(
                        text = "${match.homeScore}:${match.awayScore}",
                        style = MaterialTheme.typography.labelMedium,
                    )
                    Text(
                        text = if (match.homeTeamName == "Arsenal") {
                            if (match.homeScore > match.awayScore) "WIN"
                            else if (match.homeScore < match.awayScore) "LOSS"
                            else "DRAW"
                        } else {
                            if (match.awayScore > match.homeScore) "WIN"
                            else if (match.awayScore < match.homeScore) "LOSS"
                            else "DRAW"
                        },
                        style = MaterialTheme.typography.labelMedium,
                    )
                } else {
                    Text(text = DateUtil.getTimeString(match.matchDate),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

            }

        }

    }
}

@Composable
fun RowScope.FaintCalendarItem(
    localDate: LocalDate,
    height: Int
) {
    Text(
        modifier = Modifier
            .height(height.dp)
            .weight(1f)
            .padding(4.dp),
        text = localDate.dayOfMonth.toString(),
        style = MaterialTheme.typography.labelLarge,
        color = Color.LightGray,
        textAlign = TextAlign.Center
    )
}