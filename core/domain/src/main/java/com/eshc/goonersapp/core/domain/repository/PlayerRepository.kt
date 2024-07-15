package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.model.player.PlayerFilter
import com.eshc.goonersapp.core.domain.model.player.PlayerList
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    fun getPlayers(
        playerFilter : PlayerFilter
    ) : Flow<DataResult<PlayerList>>

    fun getPlayerDetail(playerId: Int) : Flow<Player>
}