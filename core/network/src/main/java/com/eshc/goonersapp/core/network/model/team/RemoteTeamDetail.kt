package com.eshc.goonersapp.core.network.model.team

import com.eshc.goonersapp.core.network.model.match.RemoteMatch
import kotlinx.serialization.Serializable

@Serializable
data class RemoteTeamDetail(
    val team : RemoteTeam,
    val recentlyMatchs : List<RemoteMatch>
)
