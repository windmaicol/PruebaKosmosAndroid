package com.example.pruebakosmosandroid.domain

import com.example.pruebakosmosandroid.data.TMDBRepository
import com.example.pruebakosmosandroid.data.database.entities.toDatabase
import com.example.pruebakosmosandroid.domain.model.Characters
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repository: TMDBRepository) {
    suspend operator fun invoke():List<Characters>{
        val getCharacters = repository.getAllCharacterApi()

        return if(getCharacters.isNotEmpty()){
            repository.clearCharacter()
            repository.insertCharacter(getCharacters.map { it.toDatabase() })
            getCharacters
        }else{
            repository.getAllCharacterFromDataBase()
        }
    }
}