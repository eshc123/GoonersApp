package com.eshc.goonersapp.core.domain.model.team

data class Team(
    val clubId : Int,
    val clubName: String = "",
    val clubFoundedYear: Int = 0,
    val clubImgUrl: String = "",
    val clubShortCode: String = "",
    val manager: String = "",
    val captain: String = "",
    val stadiumName: String = "",
    val clubHomeTown: String = "",
    val officialWebUrl: String = "",
    val snsFaceBook: String = "",
    val snsX: String = "",
    val snsInstagram: String = ""
)