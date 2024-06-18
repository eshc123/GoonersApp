package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.ImageCard
import com.eshc.goonersapp.core.designsystem.component.MatchItemResultChip
import com.eshc.goonersapp.core.designsystem.iconpack.IcGrid
import com.eshc.goonersapp.core.designsystem.iconpack.IcIosArrowBack
import com.eshc.goonersapp.core.designsystem.iconpack.IcList
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF555555
import com.eshc.goonersapp.core.designsystem.theme.ColorFFA5DBFF
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFE9343C
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF46B6C
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF69D4A
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.designsystem.theme.pretendard
import com.eshc.goonersapp.core.domain.model.common.MatchResult
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
    onClickDetail: (Match) -> Unit,
    onClickPrevious : () -> Unit,
    onClickNext : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier
                .wrapContentHeight()
                .weight(1f))
            Row(
                modifier = Modifier
                    .wrapContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                IconButton(
                    onClick = {  onClickPrevious() }
                ) {
                    Icon(
                        imageVector = IconPack.IcIosArrowBack,
                        contentDescription = "prev"
                    )
                }
                Text(
                    text = calendarMonthListState[pagerState.currentPage].currentMonth.format(
                        DateTimeFormatter.ofPattern(
                            "yyyy.MM"
                        )
                    ),
                    style = GnrTypography.heading2SemiBold,
                    color = ColorFF181818
                )
                IconButton(
                    onClick = { onClickNext() }
                ) {
                    Icon(
                        modifier = Modifier
                            .rotate(180f),
                        imageVector = IconPack.IcIosArrowBack,
                        contentDescription = "next"
                    )
                }
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)
            ){
                Icon(
                    imageVector =IconPack.IcList,
                    contentDescription = null,
                    modifier= Modifier
                        .align(Alignment.Center)
                        .padding(8.dp)
                        .size(24.dp)
                        .clickable {
                            onChangeCalendarType()
                        }
                )
            }

        }
        Column(modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {
                CalendarUtil.dayOfWeekList.forEach {
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
        color = if (text == "SUN") ColorFFE9343C else ColorFF181818,
        style = GnrTypography.body2Medium,
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
            color = if (localDate.dayOfWeek == DayOfWeek.SUNDAY) ColorFFE9343C else ColorFF555555,
            style = GnrTypography.body1Medium
        )
        if (matchList.containsKey(localDate)) {
            matchList[localDate]?.firstOrNull()?.let { match ->
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .background(ColorFFFFFFFF)
                        .border(1.dp, ColorFFDCDCDC, CircleShape)
                        .clip(CircleShape)
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = match.getOpponentTeamImageUrl(19),
                        contentDescription = null
                    )
                }
                if (match.isFinished) {
                    Text(
                        text = "${match.homeScore}:${match.awayScore}",
                        style = GnrTypography.body2Regular,
                        color = ColorFF181818
                    )
                    MatchItemResultChip(
                        match.getMatchResult(19).name.uppercase(),
                        color = when(match.getMatchResult(19)){
                            MatchResult.Win -> ColorFFA5DBFF
                            MatchResult.Draw -> ColorFFF69D4A
                            MatchResult.Loss -> ColorFFF46B6C
                        },
                        modifier = Modifier
                            .width(40.dp)
                            .height(15.dp)
                    )
                } else {
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = DateUtil.getTimeString(match.matchDate),
                        style = GnrTypography.body2Regular,
                        color = ColorFF181818
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
        style = GnrTypography.body1Medium,
        color = Color.LightGray,
        textAlign = TextAlign.Center
    )
}