package com.eshc.goonersapp.core.domain.usecase.player

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.core.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {

    operator fun invoke(): Flow<DataResult<List<Player>>> =
        playerRepository.getPlayers()
}