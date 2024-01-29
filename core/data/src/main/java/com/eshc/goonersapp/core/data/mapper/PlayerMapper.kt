package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.database.model.PlayerEntity
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
    positionCategory = positionCategory,
    nationality = nationality
)

fun RemotePlayer.toEntity() = PlayerEntity(
    id = id,
    name = name,
    backNumber = backNumber,
    birthDate = birthDate,
    height = height,
    weight = weight,
    imageUrl = imageUrl,
    contractStartDate = contractStartDate,
    contractEndDate = contractEndDate,
    mainPosition = mainPosition,
    nationality = nationality
)

fun PlayerEntity.toModel() = Player(
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
    nationality = nationality
)