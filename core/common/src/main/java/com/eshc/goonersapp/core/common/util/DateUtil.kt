package com.eshc.goonersapp.core.common.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val DefaultDatePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

object DateUtil {
    private val defaultDateFormat = DateTimeFormatter.ofPattern(DefaultDatePattern)

    fun getYearAndMonthAndDateString(date : String ) : String {
        if(date.isBlank()) return date
        return LocalDate.parse(date, defaultDateFormat).toString()
    }

    fun getYearAndMonthAndDateLocalDate(date : String ) : LocalDate {
        if(date.isBlank()) return LocalDate.now()
        return LocalDate.parse(date, defaultDateFormat)
    }

    fun getTimeString(date: String) : String {
        if(date.isBlank()) return date
        return LocalDateTime.parse(date, defaultDateFormat).let {
            "${it.hour}:" + "${it.minute}".padStart(2,'0')
        }
    }
}