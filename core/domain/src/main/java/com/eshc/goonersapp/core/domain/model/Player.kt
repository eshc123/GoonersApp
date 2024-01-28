package com.eshc.goonersapp.core.domain.model

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
    val positionDetail : String = "",
    val position : String = "",
    val positionCategory : String = ""
)
