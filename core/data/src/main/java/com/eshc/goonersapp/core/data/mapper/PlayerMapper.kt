package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.Player
import com.eshc.goonersapp.core.network.model.RemotePlayer

fun RemotePlayer.toModel() = Player(
    id = id,
    name = name,
    backNumber = backNumber,
    birthDate = birthDate,
    height = height,
    weight = weight,
    imageUrl = imageUrl,
    contractStartDate = contractStartDate,
    contractEndDate = contractEndDate,
    positionDetail = mainPosition,
    position = positionInitial,
    positionCategory = positionCategory
)