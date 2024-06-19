package com.eshc.goonersapp.feature.match

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.component.GnrTopLevelTopBar
import com.eshc.goonersapp.core.designsystem.iconpack.IcGrid
import com.eshc.goonersapp.core.designsystem.iconpack.IcList
import com.eshc.goonersapp.core.designsystem.iconpack.IcNotification
import com.eshc.goonersapp.core.designsystem.iconpack.IcPeople
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
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
    bottomBar : @Composable () -> Unit,
    viewModel: MatchViewModel = hiltViewModel(),
    onClickDetail: (Match) -> Unit,
    onClickUser : () -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    var calendarType by remember { mutableStateOf<CalendarType>(CalendarType.Grid) }

    Scaffold(
        topBar = {
            MatchTopBar(
                calendarType = calendarType,
                onClickViewType = {
                    calendarType = if(calendarType == CalendarType.Grid) CalendarType.List
                                    else CalendarType.Grid
                },
                onClickUser = onClickUser
            )
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
            calendarType = calendarType,
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
    calendarType : CalendarType,
    calendarList : List<CalendarDates> = CalendarUtil.getCalendarDatesListAsOneYear(LocalDate.of(2023, 8, 1)),
    onClickDetail: (Match) -> Unit
) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
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
                    onClickDetail = {
                        onClickDetail(it)
                    }
                )
            }
        }
    }
}

@Composable
fun MatchTopBar(
    calendarType: CalendarType,
    onClickViewType : () -> Unit,
    onClickUser : () -> Unit
){
    GnrTopLevelTopBar(
        modifier = Modifier.padding(horizontal = 8.dp),
        title = "Match",
    ){
        Icon(
            imageVector = when(calendarType){
                CalendarType.Grid -> IconPack.IcList
                CalendarType.List -> IconPack.IcGrid
            },
            contentDescription = null,
            modifier= Modifier
                .padding(horizontal = 8.dp)
                .size(24.dp)
                .clickable {
                    onClickViewType()
                },
            tint = ColorFF777777
        )
        Icon(
            imageVector = IconPack.IcPeople,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(24.dp)
                .clickable { onClickUser() },
            tint = ColorFF777777
        )
    }
}