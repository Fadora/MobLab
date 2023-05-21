package com.mobillabor.moblab.network

import com.mobillabor.moblab.model.Character
import com.mobillabor.moblab.model.Quote
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LOTRService {

    @GET("/character")
    suspend fun fetchLOTRCharacterList(): Response<List<Character>>

    @GET("/character/{id}")
    suspend fun fetchCharacterById(@Path("id") id: String):Response<Character>

    @GET("/character/{id}/quote")
    suspend fun fetchQuotesForCharacter(@Path("id") charId: String): Response<List<Quote>>
}