package com.eshc.goonersapp.core.domain.model.team

data class Team(
    val clubId : Int,
    val clubName : String = "",
    val officialName : String = "",
    val foundationDate : String = "",
    val imageUrl : String = "",
    val teamNickname : String = "",
    val managerId : Int = 0,
    val manager : String = "",
    val captainId : Int = 0,
    val captain : String = "",
    val stadiumName : String = "",
)