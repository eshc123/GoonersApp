package com.eshc.goonersapp.core.domain.model.player

import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.domain.model.match.Match

data class PlayerMatchStat(
    val match: Match,
    val goals: Int
) {
    val formattedDate: String by lazy {
        DateUtil.getYearAndMonthAndDateString(match.matchDate,true)
    }
}
