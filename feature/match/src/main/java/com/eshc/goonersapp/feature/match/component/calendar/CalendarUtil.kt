package com.eshc.goonersapp.feature.match.component.calendar

import java.time.LocalDate

data class CalendarDates(
    val preDates: List<LocalDate>,
    val curDates: List<LocalDate>,
    val nextDates: List<LocalDate>,
    val currentMonth : LocalDate
)

object CalendarUtil {

    fun getCalendarDatesListAsOneYear(
        startLocalDate: LocalDate,
    ): List<CalendarDates> {
        return IntRange(0,11).map {
            getCalendarDates(startLocalDate.plusMonths(it.toLong()))
        }
    }

    fun isEqualOrLessMonth(localDate: LocalDate, targetLocalDate: LocalDate): Boolean {
        return if (localDate.year < targetLocalDate.year) true
        else if (localDate.year > targetLocalDate.year) false
        else localDate.month <= targetLocalDate.month
    }


    fun getCalendarDates(localDate: LocalDate): CalendarDates {
        val preDatesEnd = localDate.withDayOfMonth(1).minusDays(1L).dayOfWeek.value % 7

        return CalendarDates(
            preDates = getPreDates(localDate, preDatesEnd),
            curDates = getCurDates(localDate),
            nextDates = getNextDates(localDate, preDatesEnd + 1, localDate.lengthOfMonth()),
            currentMonth = localDate
        )
    }

    private fun getPreDates(curDate: LocalDate, end: Int): List<LocalDate> {
        return if (end == 6) emptyList() else (0..end).map {
            curDate.withDayOfMonth(1).minusDays((it + 1).toLong())
        }.reversed()
    }

    private fun getCurDates(curDate: LocalDate): List<LocalDate> {
        return (0 until curDate.lengthOfMonth()).map {
            curDate.withDayOfMonth(1).plusDays(it.toLong())
        }
    }

    private fun getNextDates(
        curDate: LocalDate,
        preDatesSize: Int,
        curDatesSize: Int
    ): List<LocalDate> {
        return (1..(if (preDatesSize + curDatesSize > 35) 42 else 35) - preDatesSize - curDatesSize).map {
            curDate.withDayOfMonth(curDate.lengthOfMonth()).plusDays(it.toLong())
        }
    }
}