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
import com.eshc.goonersapp.feature.match.component.calendar.Calendar
import com.eshc.goonersapp.feature.match.component.calendar.CalendarMode
import com.eshc.goonersapp.feature.match.component.calendar.CalendarUtil
import java.time.LocalDate

@Composable
fun MatchRoute() {
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
            mutableStateOf(CalendarUtil.getCalendarList(selectedDate))
        }

        var currentCalendarMode by remember {
            mutableStateOf<CalendarMode>(CalendarMode.DATE)
        }

        val listState = rememberLazyGridState()

        LaunchedEffect(selectedMonth) {
            calendarListState = CalendarUtil.getCalendarList(selectedMonth)
        }

        Calendar(
            height = 700,
            headerHeight = 60,
            currentCalendarMode = currentCalendarMode,
            selectedMonth = selectedMonth,
            selectedStartDate = selectedDate,
            listState = listState,
            calendarListState = calendarListState,
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