package com.example.pruebakosmosandroid.data.network

import com.example.pruebakosmosandroid.data.model.ResultsCharactersModel
import retrofit2.Response
import retrofit2.http.GET

interface TMDBApiClient {
    @GET("character/?page=1")
    suspend fun getCharacters(): Response<ResultsCharactersModel>

}