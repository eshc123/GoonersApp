package com.eshc.goonersapp.feature.match.component.calendar

import java.time.LocalDate

data class CalendarList(
    val preDates: List<LocalDate>,
    val curDates: List<LocalDate>,
    val nextDates: List<LocalDate>,
)

object CalendarUtil {
    fun getCalendarList(localDate: LocalDate): CalendarList {
        val preDatesEnd = localDate.withDayOfMonth(1).minusDays(1L).dayOfWeek.value % 7

        return CalendarList(
            preDates = getPreDates(localDate, preDatesEnd),
            curDates = getCurDates(localDate),
            nextDates = getNextDates(localDate, preDatesEnd+1, localDate.lengthOfMonth())
        )
    }

    private fun getPreDates(curDate : LocalDate, end : Int) : List<LocalDate> {
        return if(end == 6) emptyList() else (0 .. end).map {
            curDate.withDayOfMonth(1).minusDays((it + 1).toLong())
        }.reversed()
    }

    private fun getCurDates(curDate : LocalDate) : List<LocalDate> {
        return (0 until curDate.lengthOfMonth()).map {
            curDate.withDayOfMonth(1).plusDays(it.toLong())
        }
    }

    private fun getNextDates(curDate: LocalDate,preDatesSize : Int, curDatesSize : Int) : List<LocalDate> {
        return (1..(if(preDatesSize + curDatesSize > 35) 42 else 35) - preDatesSize - curDatesSize).map {
            curDate.withDayOfMonth(curDate.lengthOfMonth()).plusDays(it.toLong())
        }
    }
}