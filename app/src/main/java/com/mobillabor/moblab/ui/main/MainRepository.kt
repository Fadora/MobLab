package com.mobillabor.moblab.ui.main

import com.mobillabor.moblab.network.LOTRService
import com.mobillabor.moblab.model.Character
import com.mobillabor.moblab.persistence.CharacterDao
import com.mobillabor.moblab.persistence.QuoteDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val lotrService: LOTRService,
    private val characterDao: CharacterDao,
) {

    suspend fun loadCharactersFromAPI():List<Character>?{
        return lotrService.fetchLOTRCharacterList().body()?.docs
    }
    suspend fun loadCharactersFromLocal(): List<Character>{
        return characterDao.getAllCharacters()
    }

    suspend fun saveFirst5CharacterToLocal(characters: List<Character> ){
        characters.forEach { item ->  characterDao.insertCharacter(item)}
    }




}