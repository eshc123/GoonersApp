package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    fun getPlayers() : Flow<DataResult<List<Player>>>

    fun getPlayerDetail(playerId: Int) : Flow<Player>
}