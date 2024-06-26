package com.eshc.goonersapp.core.domain.model.player

data class PlayerList(
    val players : List<Player>,
    val page : Int,
    val size : Int
)
