package com.eshc.goonersapp.feature.team.club.event

import androidx.compose.runtime.Stable

@Stable
data class ClubDetailUiEvent(
    val onInstagramClick: (String) -> Unit = { },
    val onFaceBookClick: (String) -> Unit = { },
    val onXClick: (String) -> Unit = { },
    val onHomePageUrlClick: (String) -> Unit = { }
)