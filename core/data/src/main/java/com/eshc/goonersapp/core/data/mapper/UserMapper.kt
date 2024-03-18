package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.user.LoginInfo
import com.eshc.goonersapp.core.network.model.user.RemoteLoginInfo

fun RemoteLoginInfo.toModel() =
    LoginInfo(
        email = email,
        nickname = nickname,
        teamId = teamId,
        accessToken = accessToken,
        refreshToken = refreshToken
    )