package com.example.pruebakosmosandroid.data

import com.example.pruebakosmosandroid.data.database.dao.CharacterDao
import com.example.pruebakosmosandroid.data.database.entities.CharacterEntity
import com.example.pruebakosmosandroid.data.model.ResultsCharactersModel
import com.example.pruebakosmosandroid.data.network.TMDBService
import com.example.pruebakosmosandroid.domain.model.Characters
import com.example.pruebakosmosandroid.domain.model.toDomain
import javax.inject.Inject

class TMDBRepository @Inject constructor(
    private val api: TMDBService,
    private val characterDao: CharacterDao) {

    suspend fun getAllCharacterApi():List<Characters>  {
        val response: ResultsCharactersModel = api.getCharacters()
        return response.results.map { it.toDomain() }
    }

    suspend fun getAllCharacterFromDataBase():List<Characters>{
        val response: List<CharacterEntity> = characterDao.getCharacterDao()
        return response.map { it.toDomain() }
    }

    suspend fun insertCharacter(characters:List<CharacterEntity>){
        characterDao.insertCharacter(characters)
    }

    suspend fun clearCharacter(){
        characterDao.deleteAllCharacters()
    }

}