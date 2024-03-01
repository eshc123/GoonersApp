package com.eshc.goonersapp.feature.match

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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
import com.eshc.goonersapp.core.designsystem.iconpack.IcGrid
import com.eshc.goonersapp.core.designsystem.iconpack.IcList
import com.eshc.goonersapp.core.domain.model.Match
import com.eshc.goonersapp.feature.match.component.calendar.CalendarGrid
import com.eshc.goonersapp.feature.match.component.calendar.CalendarList
import java.time.LocalDate

enum class CalendarType {
    Grid, List
}

@Composable
fun MatchRoute(
    viewModel: MatchViewModel = hiltViewModel(),
    onClickDetail: (Match) -> Unit,
    onShowSnackbar : (String) -> Unit
) {
    MatchScreen(
        viewModel = viewModel,
        onClickDetail = onClickDetail
    )
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MatchScreen(
    viewModel: MatchViewModel,
    onClickDetail: (Match) -> Unit
) {
    var selectedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var calendarType by remember { mutableStateOf<CalendarType>(CalendarType.Grid) }

    val matches by viewModel.matches.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        when (calendarType) {
            CalendarType.Grid -> {
                CalendarGrid(
                    height = 700,
                    headerHeight = 60,
                    matchList = matches.groupBy {
                        DateUtil.getYearAndMonthAndDateLocalDate(it.matchDate)
                    },
                    onSelectDate = {
                        selectedDate = it
                    },
                    onChangeCalendarType = {
                        calendarType = CalendarType.List
                    },
                    onClickDetail = {
                        onClickDetail(it)
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