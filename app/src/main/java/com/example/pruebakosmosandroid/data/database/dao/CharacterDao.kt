package com.example.pruebakosmosandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebakosmosandroid.data.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character_table ORDER BY id DESC")
    suspend fun getCharacterDao():List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(students:List<CharacterEntity>)

    @Query("DELETE FROM character_table")
    suspend fun deleteAllCharacters()

}