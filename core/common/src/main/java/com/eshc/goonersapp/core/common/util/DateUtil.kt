package com.eshc.goonersapp.core.common.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

const val DefaultDatePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

object DateUtil {
    private val defaultDateFormat = DateTimeFormatter.ofPattern(DefaultDatePattern)

    fun getYearAndMonthString(date: String): String {
        if (date.isBlank()) return date
        return LocalDate.parse(date, defaultDateFormat)
            .format(DateTimeFormatter.ofPattern("yyyy.MM"))
    }

    fun getYearAndMonthAndDateString(date: String,useTwoDigitYear : Boolean = false): String {
        if (date.isBlank()) return date
        return LocalDate.parse(date, defaultDateFormat)
            .format(DateTimeFormatter.ofPattern(
                if(useTwoDigitYear) "yy.MM.dd"
                else "yyyy.MM.dd"
            ))
    }

    fun getYearAndMonthAndDateAndTimeString(date: String): String {
        if (date.isBlank()) return date
        return LocalDateTime.parse(date, defaultDateFormat)
            .format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))
    }

    fun getYearAndMonthAndDateAndDayAndTimeString(date: String): String {
        if (date.isBlank()) return date
        return LocalDateTime.parse(date, defaultDateFormat).format(
            DateTimeFormatter.ofPattern(
                "yyyy.MM.dd E HH:mm",
                Locale.US
            )
        ).uppercase()
    }

    fun getMonthAndDateAndDayString(date: String): String {
        if (date.isBlank()) return date
        return LocalDateTime.parse(date, defaultDateFormat)
            .format(DateTimeFormatter.ofPattern("MM.dd E", Locale.US)).uppercase()
    }

    fun getYearAndMonthAndDateLocalDate(date: String): LocalDate {
        if (date.isBlank()) return LocalDate.now()
        return LocalDate.parse(date, defaultDateFormat)
    }

    fun getTimeString(date: String): String {
        if (date.isBlank()) return date
        return LocalDateTime.parse(date, defaultDateFormat).let {
            "${it.hour}:" + "${it.minute}".padStart(2, '0')
        }
    }
}