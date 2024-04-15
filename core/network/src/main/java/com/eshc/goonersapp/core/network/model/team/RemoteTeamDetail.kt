package com.eshc.goonersapp.core.network.model.team

import com.eshc.goonersapp.core.network.model.match.RemoteMatchTeam
import kotlinx.serialization.Serializable

@Serializable
data class RemoteTeamDetail(
    val team : RemoteTeam,
    val recentlyMatchs : List<RemoteMatchTeam>
)
