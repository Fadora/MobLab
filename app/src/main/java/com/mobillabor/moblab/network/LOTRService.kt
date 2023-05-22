package com.mobillabor.moblab.network

import com.mobillabor.moblab.model.Character
import com.mobillabor.moblab.model.CharacterListResponse
import com.mobillabor.moblab.model.Quote
import com.mobillabor.moblab.model.QuoteListResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LOTRService {

    @GET("/v2/character")
    suspend fun fetchLOTRCharacterList(): Response<CharacterListResponse>

    @GET("/v2/character/{id}")
    suspend fun fetchCharacterById(@Path("id") id: String):Response<CharacterListResponse>

    @GET("/v2/character/{id}/quote")
    suspend fun fetchQuotesForCharacter(@Path("id") charId: String): Response<QuoteListResponse>
}