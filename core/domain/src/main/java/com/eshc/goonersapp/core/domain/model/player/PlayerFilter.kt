package com.eshc.goonersapp.core.domain.model.player

data class PlayerFilter(
    val teamId : Int = 19,
    val seasonId : Int = 21646,
    val positionId : Int? = null,
    val keyword : String? = null,
    val page : Int? = null,
    val size : Int? = null
)