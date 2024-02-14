package com.eshc.goonersapp.feature.match

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.feature.match.component.calendar.Calendar
import java.time.LocalDate

@Composable
fun MatchRoute(
    viewModel: MatchViewModel = hiltViewModel()
) {
    MatchScreen(viewModel = viewModel)
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MatchScreen(
    viewModel: MatchViewModel
) {

    val now: LocalDate = LocalDate.now()

    var selectedDate by remember {
        mutableStateOf(now)
    }

    val matches by viewModel.matches.collectAsStateWithLifecycle()

//    LaunchedEffect(pagerState.currentPage) {
////        calendarMonthListState[pagerState.currentPage].currentMonth.let { currentMonth ->
////            viewModel.fetchMatchesByMonth(
////                currentMonth.withDayOfMonth(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
////                currentMonth.plusMonths(1L).withDayOfMonth(1).minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
////            )
////        }
//    }

        Calendar(
            height = 700,
            headerHeight = 60,
            matchList = matches.groupBy {
                DateUtil.getYearAndMonthAndDateLocalDate(it.matchDate)
            },
            onSelectDate = {
                selectedDate = it
            },
        )
}