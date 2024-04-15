package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.match.LineUp
import com.eshc.goonersapp.core.domain.model.match.Match
import com.eshc.goonersapp.core.domain.model.match.MatchDetail
import com.eshc.goonersapp.core.domain.model.match.MatchInformation
import com.eshc.goonersapp.core.domain.model.match.MatchRecently
import com.eshc.goonersapp.core.domain.model.match.MatchUpcoming
import com.eshc.goonersapp.core.domain.model.match.NotablePlayer
import com.eshc.goonersapp.core.domain.model.match.Performance
import com.eshc.goonersapp.core.network.model.match.RemoteMatchDetail
import com.eshc.goonersapp.core.network.model.match.RemoteMatchInformation
import com.eshc.goonersapp.core.network.model.match.RemoteMatchTeam
import com.eshc.goonersapp.core.network.model.match.RemoteMatchUpcoming
import com.eshc.goonersapp.core.network.model.match.RemoteRecentlyMatch

/**
 * [RemoteMatchTeam] Mapper
 *   - Mapping [RemoteMatchTeam] to [Match]
 */
fun RemoteMatchTeam.toModel() = Match(
    id = matchId,
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
    stadiumName = venueName,
    leagueImageUrl = leagueImage
)

/**
 * [RemoteMatchUpcoming] Mapper
 *   - Mapping [RemoteMatchUpcoming] to [MatchUpcoming]
 */
fun RemoteMatchUpcoming.toModel() = MatchUpcoming(
    matchId = matchId,
    homeTeamId = homeTeamId,
    homeTeamNickname = homeTeamNickname,
    homeTeamName = homeTeamName,
    homeTeamImageUrl = homeTeamImage,
    awayTeamId = awayTeamId,
    awayTeamNickname = awayTeamNickname,
    awayTeamName = awayTeamName,
    awayTeamImageUrl = awayTeamImage,
    matchDate = matchDate,
    stadiumName = stadiumName,
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
            playerHeight = remote.height,
            playerWeight = remote.weight,
            playerImageUrl = remote.playerImage,
            playerPosition = remote.position,
            playerPositionInitial = remote.positionInitial,
            playerGoalCount = remote.goalCount
        )
    },
    lineUp = lineUp.map { remote ->
        LineUp(
            lineUpId = remote.lineUpId,
            matchId = remote.matchId,
            playerId = remote.playerId,
            teamId = remote.teamId,
            playerName = remote.playerName,
            playerBackNumber = remote.jerseyNumber,
            formationField = remote.formationField,
            formationPosition = remote.formationPosition,
            positionId = remote.positionId,
            positionCategory = remote.positionCategory,
            positionInitial = remote.positionInitial
        )
    },
    performance = performance.map { remote ->
        Performance(
            result = remote.result,
            count = remote.count,
            opponentImageUrl = remote.opponentImage
        )
    }
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
    type = type,
    playerName = playerName,
    relatedPlayerName = relatedPlayerName
)

/**
 * [RemoteRecentlyMatch] Mapper
 *  - Mapper [RemoteRecentlyMatch] to [MatchRecently]
 */
fun RemoteRecentlyMatch.toModel() = MatchRecently(
    match = match.toModel(),
    matchDetail = matchDetail.map { remote -> remote.toModel() }
)