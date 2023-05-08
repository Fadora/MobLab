package com.mobillabor.moblab.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "character")
data class Character(
    @PrimaryKey(autoGenerate = false) var charId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "realm") val realm: String,
    @ColumnInfo(name = "race") val race: String,
    @ColumnInfo(name = "birthdate") val birthdate: String,
    @ColumnInfo(name = "spouse") val spouse: String,
    @ColumnInfo(name = "death") val dateofdeath: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "hair") val hair: String,
    @ColumnInfo(name = "quotes") val quotes: List<String>,


)
