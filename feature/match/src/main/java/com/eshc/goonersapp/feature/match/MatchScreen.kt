package com.eshc.goonersapp.feature.match

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.feature.match.component.calendar.Calendar
import com.eshc.goonersapp.feature.match.component.calendar.CalendarUtil
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MatchRoute(
    viewModel: MatchViewModel = hiltViewModel()
) {
    MatchScreen(viewModel = viewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MatchScreen(
    viewModel: MatchViewModel
) {
    val pagerState = rememberPagerState(){
        12
    }
    val now: LocalDate = LocalDate.now()

    var selectedDate by remember {
        mutableStateOf(now)
    }

    val calendarMonthListState by remember {
        mutableStateOf(CalendarUtil.getCalendarDatesListAsOneYear(LocalDate.of(2023,8,1)))
    }

    val matches by viewModel.matches.collectAsStateWithLifecycle()

    LaunchedEffect(pagerState.currentPage) {
        calendarMonthListState[pagerState.currentPage].currentMonth.let { currentMonth ->
            viewModel.fetchMatchesByMonth(
                currentMonth.withDayOfMonth(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                currentMonth.plusMonths(1L).withDayOfMonth(1).minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        beyondBoundsPageCount = 1
    ) {
        Calendar(
            height = 700,
            headerHeight = 60,
            selectedStartDate = selectedDate,
            calendarDatesState = calendarMonthListState[it],
            matchList = matches.groupBy {
                DateUtil.getYearAndMonthAndDateLocalDate(it.matchDate)
            },
            onSelectDate = {

            },

        )
    }
}