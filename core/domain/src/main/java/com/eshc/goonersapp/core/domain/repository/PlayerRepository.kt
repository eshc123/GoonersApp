package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    fun getPlayers() : Flow<List<Player>>

    fun getPlayerDetail(playerId: Int) : Flow<Player>
}