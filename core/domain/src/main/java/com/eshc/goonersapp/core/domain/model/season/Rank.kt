package com.eshc.goonersapp.core.domain.model.season

data class Rank(
    val standingId: Int,
    val position: Int,
    val points: Int,
    val wins: Int,
    val loss: Int,
    val draw: Int,
    val goalDifference: Int,
    val teamId: Int,
    val teamName: String,
    val shortCode: String
)