package com.eshc.goonersapp.core.domain.usecase

import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {

    operator fun invoke(): Flow<List<Player>> =
        playerRepository.getPlayers()
}