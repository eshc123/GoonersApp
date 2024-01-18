package com.eshc.goonersapp.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "player"
)
data class PlayerEntity(
    @PrimaryKey
    val id : Int,
    val position : String,
    val name : String,
    @ColumnInfo(name = "birth_date")
    val birthDate : String,
    val height : Int,
    val weight : Int,
    @ColumnInfo(name = "back_number")
    val backNumber : Int,
    @ColumnInfo(name = "country_id")
    val countryId : Int,
    @ColumnInfo(name = "image_url")
    val imageUrl : String
)