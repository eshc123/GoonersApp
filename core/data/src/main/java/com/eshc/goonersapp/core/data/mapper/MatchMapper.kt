package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.match.PlayerLineup
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchData
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchLineup
import com.eshc.goonersapp.core.domain.model.match.NotablePlayer
import com.eshc.goonersapp.core.domain.model.match.Performance
import com.eshc.goonersapp.core.domain.model.match.TeamLineup
import com.eshc.goonersapp.core.domain.model.match.toMatchDetailType
import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import com.eshc.goonersapp.core.network.model.match.RemoteMatchData
import com.eshc.goonersapp.core.network.model.match.RemoteMatchDetail
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchLineup
import com.eshc.goonersapp.core.network.model.match.RemotePlayerLineup
import com.eshc.goonersapp.core.network.model.match.RemoteTeamLineup

/**
 * [RemoteMatch] Mapper
 *   - Mapping [RemoteMatch] to [Match]
 */
fun RemoteMatch.toModel() = Match(
    id = matchId,
    seasonId = seasonId,
    homeTeamId = homeTeamId,
    homeTeamName = homeTeamName,
    homeTeamImageUrl = homeTeamImage,
    homeTeamNickname = homeTeamNickname,
    awayTeamId = awayTeamId,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamImage,
    awayTeamNickname = awayTeamNickname,
    matchDate = matchDate,
    homeScore = homeScore,
    awayScore = awayScore,
    round = round,
    isFinished = isFinished == 1,
    stadiumName = venueName.toString(),
    leagueImageUrl = leagueImage
)


/**
 * [RemoteMatchInformation] Mapper
 *   - Mapping [RemoteMatchInformation] to [MatchInformation]
 */
fun RemoteMatchInformation.toModel() = MatchInformation(
    notablePlayer = notablePlayer?.let { remote ->
        NotablePlayer(
            playerId = remote.playerId,
            playerName = remote.playerName,
            playerHeight = remote.height ?: 0,
            playerWeight = remote.weight  ?: 0,
            playerImageUrl = remote.playerImage  ?: "",
            playerPosition = remote.position  ?: "",
            playerPositionInitial = remote.positionInitial  ?: "",
            playerGoalCount = remote.goalCount  ?: 0,
            playerParticipationCount = remote.participationCount ?: 0
        )
    },
    performance = Performance(
        opponentImageUrl = performance.opponentImage,
        win = performance.win,
        draw = performance.draw,
        lose = performance.lose
    )
)

/**
 * [RemoteMatchDetail] Mapper
 *  - Mapping [RemoteMatchDetail] to [MatchDetail]
 */
fun RemoteMatchDetail.toModel() = MatchDetail(
    matchDetailId = matchDetailId,
    matchId = matchId,
    teamId = teamId,
    playerId = playerId,
    relatedPlayerId = relatedPlayerId,
    minute = minute,
    extraMinute = extraMinute,
    type = type.toMatchDetailType(),
    playerName = playerName,
    relatedPlayerName = relatedPlayerName
)

/**
 * [RemoteMatchData] Mapper
 *  - Mapper [RemoteMatchData] to [MatchData]
 */
fun RemoteMatchData.toModel() = MatchData(
    match = match.toModel(),
    matchDetail = matchDetail.map { remote -> remote.toModel() }
)

/**
 * [RemoteMatchLineup] Mapper
 *  - Mapper [RemoteMatchLineup] to [MatchLineup]
 */
fun RemoteMatchLineup.toModel() = MatchLineup(
    homeLineup = homeLineup.toModel(),
    awayLineup = awayLineup.toModel()
)

fun RemoteTeamLineup.toModel() = TeamLineup(
    teamId = teamId.toInt(),
    formation = formation,
    playerLineup = players.map { remote -> remote.toModel() }
)

fun RemotePlayerLineup.toModel() = PlayerLineup(
    lineUpId = lineUpId,
    matchId = matchId,
    playerId = playerId,
    teamId = teamId,
    playerName = playerName,
    playerImageUrl = playerImageUrl,
    playerBackNumber = jerseyNumber,
    formationField = formationField,
    formationPosition = formationPosition,
    positionId = positionId,
    positionCategory = positionCategory,
    positionInitial = positionInitial
)
