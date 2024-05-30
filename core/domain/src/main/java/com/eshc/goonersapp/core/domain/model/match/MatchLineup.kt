package com.eshc.goonersapp.core.domain.model.match

import com.eshc.goonersapp.core.domain.model.player.Player

data class MatchLineup(
    val homeLineup : TeamLineup,
    val awayLineup : TeamLineup
)

data class TeamLineup(
    val teamId : Int,
    val formation : String,
    val playerLineup : List<PlayerLineup>
){
    private fun getFormationAsList() : List<Int> {
        return listOf(1) + formation.split("-").map { it.toIntOrNull() ?: 0 }
    }


    fun groupStartingPlayersByPosition(): List<List<PlayerLineup>> {
        val actualPositionList = getFormationAsList()
        val sortedPlayers = playerLineup.filter { it.formationField != "null" }.sortedBy { it.formationPosition }

        return actualPositionList.mapIndexed { index, i ->
            val p = i - 1
            val s = actualPositionList.subList(0, index).sum()
            sortedPlayers.slice(s..s + p)
        }
    }
}

data class PlayerLineup(
    val lineUpId: Long,
    val matchId: Int,
    val playerId: Int,
    val teamId: Int,
    val playerName: String,
    val playerImageUrl : String,
    val playerBackNumber: Int,
    val formationField: String?,
    val formationPosition: Int?,
    val positionId: Int,
    val positionCategory: String,
    val positionInitial: String
)