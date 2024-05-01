package com.eshc.goonersapp.core.domain.model.player

data class Player(
    val id :Int,
    val name : String = "",
    val backNumber : Int = 0,
    val birthDate : String = "",
    val height : Int = 0,
    val weight : Int = 0,
    val imageUrl : String = "",
    val contractStartDate : String = "",
    val contractEndDate : String = "",
    val position : String = "",
    val positionInitial : String = "",
    val positionCategory : String = "",
    val nationality : String = "",
    val nationalityImageUrl: String = ""
) {
    private val names : List<String>
        get() = name.split(" ")

    val firstName : String
        get() = names.firstOrNull() ?: ""

    val lastNames : String
        get() = names.let {
            if(it.size > 1) names.subList(1, names.lastIndex + 1).joinToString(" ")
            else ""
        }

    val displayName : String
        get() = firstName + (if(lastNames.isEmpty()) "" else "\n${lastNames}")

}

enum class PlayerPosition(val positionCategory: String) {
    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward")
}