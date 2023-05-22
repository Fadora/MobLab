package com.mobillabor.moblab.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "character")
data class Character(
    @PrimaryKey(autoGenerate = false) var _id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "realm") val realm: String?,
    @ColumnInfo(name = "race") val race: String?,
    @ColumnInfo(name = "birthdate") val birthdate: String?,
    @ColumnInfo(name = "spouse") val spouse: String?,
    @ColumnInfo(name = "death") val dateofdeath: String?,
    @ColumnInfo(name = "height") val height: String?,
    @ColumnInfo(name = "hair") val hair: String?,
   // @ColumnInfo(name = "quotes") val quotes: ArrayList<String>, //külön entity van rá, külö lekérédezés
) {

    /*
    @ProvidedTypeConverter
    class Converters(
    ) {

        inline fun <reified T> Gson.fromJson(json: String) =
            fromJson<T>(json, object : TypeToken<T>() {}.type)
        @TypeConverter
        fun fromStringArrayList(value: ArrayList<String>): String {

            return Gson().toJson(value)
        }

        @TypeConverter
        fun toStringArrayList(value: String): ArrayList<String> {
            return try {
                Gson().fromJson<ArrayList<String>>(value) //using extension function
            } catch (e: Exception) {
                arrayListOf()
            }
        }
    }*/
}