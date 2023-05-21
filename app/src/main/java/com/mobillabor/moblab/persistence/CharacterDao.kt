package com.mobillabor.moblab.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mobillabor.moblab.model.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM character WHERE charId =:id")
    suspend fun getCharacterById(id: String): Character

    @Query ("SELECT * FROM character")
    suspend fun getAllCharacters(): List<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(newCharacter: Character)

    @Update
    suspend fun updateCharacter(character: Character)

    @Delete
    suspend fun deleteCharacter(character: Character)
}
