package com.mobillabor.moblab.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mobillabor.moblab.model.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character WHERE id=:id")
        fun getCharacterById(id: Long): List<Character>

    @Query ("SELECT * FROM character")
    fun getAllCharacters(): List<Character>

    @Insert
    fun insertCharacter(newCharacter: Character)

    @Update
    fun updateCharacter(character: Character)

    @Delete
    fun deleteCharacter(character: Character)
}
