package com.eshc.goonersapp.core.domain.usecase

import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayerDetailUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {

    operator fun invoke(playerId : Int): Flow<Player> =
        playerRepository.getPlayerDetail(playerId)
}