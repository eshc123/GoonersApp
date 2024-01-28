package com.eshc.goonersapp.core.common.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val DefaultDatePattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"

object DateUtil {
    private val defaultDateFormat = DateTimeFormatter.ofPattern(DefaultDatePattern)

    fun getYearAndMonthAndDate(date : String ) : String {
        if(date.isBlank()) return date
        return LocalDate.parse(date, defaultDateFormat).toString()
    }
}