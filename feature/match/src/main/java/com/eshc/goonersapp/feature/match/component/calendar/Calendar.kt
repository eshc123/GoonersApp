package com.eshc.goonersapp.feature.match.component.calendar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.domain.model.Match
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

enum class CalendarMode {
    DATE, MONTH, YEAR
}

@Composable
fun Calendar(
    height: Int,
    headerHeight: Int,
    yearRangeList: List<Int> = IntRange(
        1901,
        java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
    ).toList(),
    currentCalendarMode: CalendarMode,
    selectedMonth: LocalDate,
    selectedStartDate: LocalDate,
    selectedEndDate: LocalDate? = null,
    listState: LazyGridState,
    calendarDatesState: CalendarDates,
    matchList : Map<LocalDate,List<Match>>,
    onChangeMonth: (LocalDate) -> Unit,
    onChangeDate: (LocalDate) -> Unit,
    onSelectDate: (LocalDate) -> Unit,
    onChangeCurrentCalendarMode: (CalendarMode) -> Unit
) {
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
            Icon(
                modifier = Modifier.clickable {
                    when (currentCalendarMode) {
                        CalendarMode.DATE -> {
                            onChangeMonth(selectedMonth.minusMonths(1L))
                        }

                        else -> {
                            if (selectedMonth.year > 1901)
                                onChangeMonth(selectedMonth.minusYears(1L))
                        }
                    }
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
            Box(
                modifier = Modifier.weight(1f)
            ) {
                when (currentCalendarMode) {
                    CalendarMode.DATE -> {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clickable {
                                    onChangeCurrentCalendarMode(CalendarMode.MONTH)
                                },
                            text = selectedMonth.format(DateTimeFormatter.ofPattern("yyyy.MM")),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    CalendarMode.MONTH -> {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clickable {
                                    onChangeCurrentCalendarMode(CalendarMode.YEAR)
                                },
                            text = selectedMonth.format(DateTimeFormatter.ofPattern("yyyy")),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    CalendarMode.YEAR -> {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = selectedMonth.format(DateTimeFormatter.ofPattern("yyyy")),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }

            }
            //if (currentCalendarMode == CalendarMode.DATE)
            Icon(
                modifier = Modifier
                    .rotate(180f)
                    .clickable {
                        when (currentCalendarMode) {
                            CalendarMode.DATE -> {
                                onChangeMonth(selectedMonth.plusMonths(1L))
                            }

                            else -> {
                                if (selectedMonth.year < yearRangeList.last())
                                    onChangeMonth(selectedMonth.plusYears(1L))
                            }
                        }
                    },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = currentCalendarMode == CalendarMode.DATE
            ) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    columns = GridCells.Fixed(7),

                    ) {
                    items(listOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")) {
                        CalendarDayItem(it, 24)
                    }

                    items(calendarDatesState.preDates) { localDate ->
                        FaintCalendarItem(localDate, (height - headerHeight) / 7)
                    }
                    items(calendarDatesState.curDates) { localDate ->
                        CalendarItem(
                            localDate,
                            selectedStartDate,
                            selectedEndDate,
                            (height - headerHeight) / 7,
                            matchList
                        ) {
                            onSelectDate(it)
                            onChangeDate(it)
                        }
                    }
                    items(calendarDatesState.nextDates) { localDate ->
                        FaintCalendarItem(localDate, (height - headerHeight) / 7)
                    }
                }
            }
            AnimatedVisibility(
                visible = currentCalendarMode == CalendarMode.MONTH
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp, start = 8.dp, end = 8.dp)
                ) {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.TopCenter),
                        columns = GridCells.Fixed(4),
                        horizontalArrangement = Arrangement.Center,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(IntRange(1, 12).toList()) {
                            CalendarMonthItem(
                                onClick = {
                                    onChangeMonth(selectedMonth.withMonth(it.toInt()))
                                    val last = LocalDate.of(selectedStartDate.year, it.toInt(), 1)
                                        .withDayOfMonth(
                                            LocalDate.of(selectedStartDate.year, it.toInt(), 1)
                                                .lengthOfMonth()
                                        ).dayOfMonth
                                    onChangeDate(
                                        if (selectedStartDate.dayOfMonth > last)
                                            LocalDate.of(selectedStartDate.year, it.toInt(), last)
                                        else {
                                            LocalDate.of(
                                                selectedStartDate.year,
                                                it.toInt(),
                                                selectedStartDate.dayOfMonth
                                            )
                                        }
                                    )
                                    onChangeCurrentCalendarMode(CalendarMode.DATE)
                                },
                                it.toString(),
                                (height - headerHeight) / 4,
                                isSelected = it == selectedMonth.monthValue
                            )
                        }
                    }
                }

            }
            AnimatedVisibility(
                visible = currentCalendarMode == CalendarMode.YEAR
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp, bottom = 4.dp),
                        columns = GridCells.Fixed(4),
                        userScrollEnabled = true,
                        state = listState,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        items(yearRangeList) {
                            CalendarYearItem(
                                onClick = {
                                    onChangeMonth(selectedMonth.withYear(it.toInt()))
                                    onChangeDate(
                                        LocalDate.of(
                                            it.toInt(),
                                            selectedStartDate.month,
                                            selectedStartDate.dayOfMonth
                                        )
                                    )
                                    onChangeCurrentCalendarMode(CalendarMode.MONTH)
                                },
                                it.toString(),
                                isSelected = selectedMonth.year == it
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CalendarYearItem(
    onClick: (String) -> Unit,
    text: String,
    height: Int = 28,
    fontSize: TextUnit = 20.sp,
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .border(
                    if (isSelected)
                        BorderStroke(1.dp, Color.Red)
                    else BorderStroke(0.dp, Color.Transparent),
                    shape = CircleShape
                )
                .clickable {
                    onClick(text)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = text,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }

    }
}


@Composable
fun CalendarMonthItem(
    onClick: (String) -> Unit,
    text: String,
    height: Int,
    fontSize: TextUnit = 20.sp,
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .wrapContentWidth()
                .aspectRatio(1f)
                .border(
                    if (isSelected)
                        BorderStroke(1.dp, Color.Red)
                    else BorderStroke(0.dp, Color.Transparent),
                    shape = CircleShape
                )
                .clickable {
                    onClick(text)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center),
                text = text,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }

}


@Composable
fun CalendarDayItem(
    text: String,
    height: Int
) {
    Box(
        modifier = Modifier
            .padding(bottom = 6.dp)
            .height(height.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(height.dp),
                text = text,
                fontSize = 12.sp,
                color = if (text == "SUN" || text == "SAT") Color.Red else Color.Gray,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun CalendarItem(
    localDate: LocalDate,
    selectedDate: LocalDate,
    selectedEndDate: LocalDate? = null,
    height: Int,
    matchList: Map<LocalDate, List<Match>>,
    onSelectDate: (LocalDate) -> Unit,
) {
    Column(
        modifier = Modifier
            .height(height.dp)
            .background(
                if (selectedEndDate != null && (localDate.isEqual(selectedEndDate) || localDate.isEqual(
                        selectedDate
                    ) || (localDate.isAfter(selectedDate) && localDate.isBefore(selectedEndDate)))
                )
                    Color.Red.copy(alpha = 0.5f)
                else
                    Color.Transparent
            )
            .clickable {
                onSelectDate(localDate)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(CircleShape)
                .border(
                    if (selectedDate.year == localDate.year && selectedDate.month == localDate.month && selectedDate.dayOfMonth == localDate.dayOfMonth)
                        BorderStroke(1.dp, Color.Red)
                    else BorderStroke(0.dp, Color.Transparent),
                    CircleShape
                )
                .padding(4.dp)

        ) {
            Text(
                modifier = Modifier,
                text = localDate.dayOfMonth.toString(),
                fontSize = 14.sp,
                color = if (localDate.dayOfWeek in setOf(
                        DayOfWeek.SATURDAY,
                        DayOfWeek.SUNDAY
                    )
                ) Color.Red else Color.Black,
                fontWeight = FontWeight.Medium
            )
        }
        if (matchList.containsKey(localDate)) {
            matchList[localDate]?.firstOrNull()?.let { match ->
                AsyncImage(
                    modifier = Modifier.size(24.dp),
                    model = if(match.homeTeamName == "Arsenal") match.awayTeamImageUrl else match.homeTeamImageUrl,
                    contentDescription = null
                )
                if(match.isFinished){
                    Text(text = "${match.homeScore}:${match.awayScore}",
                        fontSize = 12.sp)
                    Text(
                        text = if(match.homeTeamName == "Arsenal"){
                            if(match.homeScore > match.awayScore) "WIN"
                            else if(match.homeScore < match.awayScore) "LOSS"
                            else "DRAW"
                        }else {
                            if(match.awayScore > match.homeScore) "WIN"
                            else if(match.awayScore < match.homeScore) "LOSS"
                            else "DRAW"
                        }, fontSize = 12.sp)
                }else {
                    Text(text = DateUtil.getTimeString(match.matchDate), fontSize = 12.sp)
                }

            }

        }


    }
}

@Composable
fun FaintCalendarItem(
    localDate: LocalDate,
    height: Int
) {
    Box(
        modifier = Modifier
            .height(height.dp),
        contentAlignment = Alignment.TopCenter

    ) {
        Box(modifier = Modifier.padding(4.dp)) {
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                text = localDate.dayOfMonth.toString(),
                fontSize = 14.sp,
                color = Color.LightGray
            )

        }
    }
}