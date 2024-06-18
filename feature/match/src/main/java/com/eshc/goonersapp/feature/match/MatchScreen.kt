package com.eshc.goonersapp.feature.match

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
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
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.feature.match.component.calendar.CalendarDates
import com.eshc.goonersapp.feature.match.component.calendar.CalendarGrid
import com.eshc.goonersapp.feature.match.component.calendar.CalendarList
import com.eshc.goonersapp.feature.match.component.calendar.CalendarUtil
import com.eshc.goonersapp.feature.match.event.UpdateMonthEvent
import java.time.LocalDate

enum class CalendarType {
    Grid, List
}

@Composable
fun MatchRoute(
    topBar : @Composable () -> Unit,
    bottomBar : @Composable () -> Unit,
    viewModel: MatchViewModel = hiltViewModel(),
    onClickDetail: (Match) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        }
    ) { padding ->
        MatchScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            viewModel = viewModel,
            onClickDetail = onClickDetail
        )
    }

}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MatchScreen(
    modifier: Modifier = Modifier,
    viewModel: MatchViewModel,
    calendarList : List<CalendarDates> = CalendarUtil.getCalendarDatesListAsOneYear(LocalDate.of(2023, 8, 1)),
    onClickDetail: (Match) -> Unit
) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var calendarType by remember { mutableStateOf<CalendarType>(CalendarType.Grid) }
    val matches by viewModel.matches.collectAsStateWithLifecycle()
    val calendarMonthListState by remember {
        mutableStateOf(calendarList)
    }
    val calendarGridPagerState = rememberPagerState { calendarList.size }

    LaunchedEffect(Unit ) {
        viewModel.mUpdateCurrentMonthEvent.collect {
            when(it){
                UpdateMonthEvent.UpdateToNextMonth -> {
                    calendarGridPagerState.animateScrollToPage(
                        calendarGridPagerState.currentPage + 1
                    )
                }
                UpdateMonthEvent.UpdateToPreviousMonth -> {
                    calendarGridPagerState.animateScrollToPage(
                        calendarGridPagerState.currentPage - 1
                    )

                }
                is UpdateMonthEvent.UpdateToTargetMonth -> {
                    //TODO
                }
            }
        }
    }

    Column(
        modifier = modifier
    ) {
        when (calendarType) {
            CalendarType.Grid -> {
                CalendarGrid(
                    height = 700,
                    headerHeight = 60,
                    matchList = matches.groupBy {
                        DateUtil.getYearAndMonthAndDateLocalDate(it.matchDate)
                    },
                    calendarMonthListState = calendarMonthListState,
                    pagerState = calendarGridPagerState,
                    onSelectDate = {
                        selectedDate = it
                    },
                    onChangeCalendarType = {
                        calendarType = CalendarType.List
                    },
                    onClickDetail = {
                        onClickDetail(it)
                    },
                    onClickPrevious = {
                        if(calendarGridPagerState.currentPage != 0)
                            viewModel.updateCurrentMonth(UpdateMonthEvent.UpdateToPreviousMonth)
                    },
                    onClickNext = {
                        if(calendarGridPagerState.currentPage < calendarGridPagerState.pageCount)
                            viewModel.updateCurrentMonth(UpdateMonthEvent.UpdateToNextMonth)
                    }
                )
            }

            CalendarType.List -> {
                CalendarList(
                    season = "2023-2024",
                    headerHeight = 60,
                    matchList = matches.groupBy {
                        DateUtil.getYearAndMonthString(it.matchDate)
                    },
                    onChangeCalendarType = {
                        calendarType = CalendarType.Grid
                    },
                    onClickDetail = {
                        onClickDetail(it)
                    }
                )
            }
        }

    }

}