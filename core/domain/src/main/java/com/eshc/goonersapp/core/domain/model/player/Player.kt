package com.eshc.goonersapp.core.domain.model.player

import com.eshc.goonersapp.core.common.util.DateUtil.getYearAndMonthAndDateLocalDate
import java.time.LocalDate
import java.time.Period

data class Player(
    val id: Int,
    val name: String = "",
    val backNumber: Int = 0,
    val birthDate: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    val imageUrl: String = "",
    val contractStartDate: String = "",
    val contractEndDate: String = "",
    val position: String = "",
    val positionInitial: String = "",
    val positionCategory: String = "",
    val nationality: String = "",
    val nationalityImageUrl: String = ""
) {
    private val names: List<String>
        get() = name.split(" ")

    private val firstName: String
        get() = names.firstOrNull() ?: ""

    private val lastNames: String
        get() = names.let {
            if (it.size > 1) names.subList(1, names.lastIndex + 1).joinToString(" ")
            else ""
        }

    val displayName: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        firstName + (if (lastNames.isEmpty()) "" else "\n${lastNames}")
    }

    val age: Int by lazy(LazyThreadSafetyMode.PUBLICATION) {
        Period.between(
            getYearAndMonthAndDateLocalDate(birthDate),
            LocalDate.now()
        ).years
    }

}

enum class PlayerPosition(val positionCategory: String) {
    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward")
}