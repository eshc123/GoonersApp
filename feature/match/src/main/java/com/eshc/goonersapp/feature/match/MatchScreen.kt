package com.eshc.goonersapp.feature.match

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.feature.match.component.calendar.Calendar
import com.eshc.goonersapp.feature.match.component.calendar.CalendarMode
import com.eshc.goonersapp.feature.match.component.calendar.CalendarUtil
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MatchRoute(
    viewModel: MatchViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val now: LocalDate = LocalDate.now()

        var selectedDate by remember {
            mutableStateOf(now)
        }

        var selectedMonth by remember {
            mutableStateOf(now)
        }

        var calendarListState by remember {
            mutableStateOf(CalendarUtil.getCalendarDates(selectedDate))
        }

        var currentCalendarMode by remember {
            mutableStateOf<CalendarMode>(CalendarMode.DATE)
        }

        val listState = rememberLazyGridState()

        val matches by viewModel.matches.collectAsStateWithLifecycle()

        LaunchedEffect(selectedMonth) {
            calendarListState = CalendarUtil.getCalendarDates(selectedMonth)
            viewModel.fetchMatchesByMonth(
                selectedMonth.withDayOfMonth(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                selectedMonth.plusMonths(1L).withDayOfMonth(1).minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )
        }

        Calendar(
            height = 700,
            headerHeight = 60,
            currentCalendarMode = currentCalendarMode,
            selectedMonth = selectedMonth,
            selectedStartDate = selectedDate,
            listState = listState,
            calendarDatesState = calendarListState,
            matchList = matches.groupBy {
                DateUtil.getYearAndMonthAndDateLocalDate(it.matchDate)
            },
            onChangeMonth  = {
                selectedMonth = it
            },
            onChangeDate = {
                selectedDate = it
            },
            onSelectDate = {
//                onSelectDate(it)
            },
            onChangeCurrentCalendarMode = {
                currentCalendarMode = it
            }

        )
    }
}