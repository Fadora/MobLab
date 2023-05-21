package com.mobillabor.moblab.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = false) var _id: String,
    @ColumnInfo(name = "dialog") val dialog: String,
    @ColumnInfo(name = "movie") val movie: String,
    @ColumnInfo(name = "character") val character: String,
)

