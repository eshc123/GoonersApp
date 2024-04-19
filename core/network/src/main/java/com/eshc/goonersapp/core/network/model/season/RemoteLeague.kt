package com.eshc.goonersapp.core.network.model.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteLeague(
    @SerialName("league_id") val leagueId : Int,
    @SerialName("league_name") val leagueName : String,
    @SerialName("short_code") val shortCode : String,
    @SerialName("league_image_url") val leagueImageUrl : String,
    @SerialName("season_id") val seasonId : Int,
    @SerialName("season") val season : String,
    @SerialName("team_id") val teamId : Int
)
