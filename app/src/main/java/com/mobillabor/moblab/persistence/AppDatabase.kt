package com.mobillabor.moblab.persistence

import android.content.Context
import android.content.res.Resources
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobillabor.moblab.model.Quote
import com.mobillabor.moblab.model.Character
import javax.sql.DataSource

@Database(entities = [Character::class, Quote::class], version = 1, exportSchema = false)
//@TypeConverters(com.mobillabor.moblab.model.Character.Converters::class)
abstract class AppDatabase :RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun quoteDao(): QuoteDao

}