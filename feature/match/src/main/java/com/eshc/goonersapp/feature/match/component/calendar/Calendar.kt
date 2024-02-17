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
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.Match
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarGrid(
    height: Int,
    headerHeight: Int,
    matchList: Map<LocalDate, List<Match>>,
    onSelectDate: (LocalDate) -> Unit
) {
    val calendarMonthListState by remember {
        mutableStateOf(CalendarUtil.getCalendarDatesListAsOneYear(LocalDate.of(2023, 8, 1)))
    }

    val listState = rememberLazyListState()
    val curIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    ) {
        Row(
            modifier = Modifier
                .height(headerHeight.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = calendarMonthListState[curIndex].currentMonth.format(
                        DateTimeFormatter.ofPattern(
                            "yyyy.MM"
                        )
                    ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

            }

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
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                state = listState,
                flingBehavior = rememberSnapFlingBehavior(lazyListState = listState)
            ) {
                items(12) {
                    Column(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        for (i in 0 until calendarMonthListState[it].getAllDates().size / 7) {
                            Row(
                                modifier = Modifier.fillParentMaxWidth(),
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
                                            onSelectDate(it)
                                        }
                                    else {
                                        FaintCalendarItem(localDate, (height - headerHeight) / 7)
                                    }
                                }
                            }
                        }
                    }

                }

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarList(
    matchList: Map<LocalDate, List<Match>>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        matchList.forEach { (localDate, matches) ->
            stickyHeader {
                Text(
                    text = localDate.format(DateTimeFormatter.ofPattern("yyyy.MM")),
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp,
                    letterSpacing = 0.1.sp
                )
            }
            items(matches){
                CalendarListItem(
                    it
                )
            }
        }

    }
}

@Composable
fun CalendarListItem(
    match: Match
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = DateUtil.getYearAndMonthAndDateAndTimeString(match.matchDate),
            fontFamily = pretendard,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            fontSize = 16.sp,
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
                modifier = Modifier.size(24.dp),
                model = match.homeTeamImageUrl,
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = "${match.homeScore} : ${match.awayScore}",
                fontFamily = pretendard,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 16.sp,
                letterSpacing = 0.1.sp
            )
            AsyncImage(
                modifier = Modifier.size(24.dp),
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
        fontSize = 12.sp,
        color = if (text == "SUN" || text == "SAT") Color.Red else Color.Gray,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}

@Composable
fun RowScope.CalendarItem(
    localDate: LocalDate,
    height: Int,
    matchList: Map<LocalDate, List<Match>>,
    onSelectDate: (LocalDate) -> Unit,
) {
    Column(
        modifier = Modifier
            .height(height.dp)
            .weight(1f)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onSelectDate(localDate)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = localDate.dayOfMonth.toString(),
            fontSize = 14.sp,
            color = if (localDate.dayOfWeek in setOf(
                    DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
                )
            ) Color.Red else Color.Black,
            fontWeight = FontWeight.Medium
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
                        fontSize = 12.sp
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
                        }, fontSize = 12.sp
                    )
                } else {
                    Text(text = DateUtil.getTimeString(match.matchDate), fontSize = 12.sp)
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
        fontSize = 14.sp,
        color = Color.LightGray,
        textAlign = TextAlign.Center
    )
}