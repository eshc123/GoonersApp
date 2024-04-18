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
    val nationality : String = ""
)

enum class PlayerPosition(val positionCategory: String) {
    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    FORWARD("Forward")
}