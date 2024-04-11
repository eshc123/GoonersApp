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
    @ColumnInfo(name = "position")
    val position : String,
    val name : String,
    @ColumnInfo(name = "birth_date")
    val birthDate : String,
    val height : Int,
    val weight : Int,
    @ColumnInfo(name = "back_number")
    val backNumber : Int,
    val nationality : String,
    @ColumnInfo(name = "image_url")
    val imageUrl : String,
    @ColumnInfo(name = "contract_start_date")
    val contractStartDate : String = "",
    @ColumnInfo(name = "contract_end_date")
    val contractEndDate : String = "",
)