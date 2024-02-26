package com.example.pruebakosmosandroid.data.network

import com.example.pruebakosmosandroid.data.model.ResultsCharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TMDBService @Inject constructor(private val api: TMDBApiClient) {

    suspend fun getCharacters(): ResultsCharactersModel {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters()
            response.body()!!
        }
    }
}