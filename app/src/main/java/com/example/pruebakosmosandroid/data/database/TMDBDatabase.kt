package com.example.pruebakosmosandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebakosmosandroid.data.database.dao.CharacterDao
import com.example.pruebakosmosandroid.data.database.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
}