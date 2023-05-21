package com.mobillabor.moblab.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mobillabor.moblab.model.Quote

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote WHERE character =:charId")
    suspend fun getQuotesForCharacter(charId: String): List<Quote>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(newQuote: Quote)
    @Update
    suspend fun updateQuote(quote: Quote)
    @Delete
    suspend fun deleteQuote(quote: Quote)
}
