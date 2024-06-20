package com.eshc.goonersapp.feature.match.event

sealed class UpdateMonthEvent {
    data object UpdateToPreviousMonth : UpdateMonthEvent()
    data object UpdateToNextMonth : UpdateMonthEvent()
    data class UpdateToTargetMonth(val targetMonth : Int) : UpdateMonthEvent()
}