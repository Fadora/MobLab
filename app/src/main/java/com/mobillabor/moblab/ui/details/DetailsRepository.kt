package com.mobillabor.moblab.ui.details

import com.mobillabor.moblab.model.Quote
import com.mobillabor.moblab.model.Character
import com.mobillabor.moblab.network.LOTRService
import com.mobillabor.moblab.persistence.CharacterDao
import com.mobillabor.moblab.persistence.QuoteDao
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val lotrService: LOTRService,
    private val characterDao: CharacterDao,
    private val quoteDao: QuoteDao
){
    suspend fun loadCharacterFromAPI(id: String): Character?{
       return lotrService.fetchCharacterById(id).body()
    }
    suspend fun loadCharacterFromLocal(id: String): Character{
        return characterDao.getCharacterById(id)
    }

    suspend fun loadQuoteForCharFromAPI( id: String): List<Quote>? {
        return lotrService.fetchQuotesForCharacter(id).body()
    }
    suspend fun loadQuoteForCharFromLocal(id: String): List<Quote>{
        return quoteDao.getQuotesForCharacter(id)
    }

    suspend fun saveFirst5Quotes(quotes: List<Quote>){
        quotes.forEach { item -> quoteDao.insertQuote(item) }
    }
}