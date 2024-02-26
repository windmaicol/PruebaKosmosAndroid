package com.example.pruebakosmosandroid.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pruebakosmosandroid.data.model.OriginModel
import com.example.pruebakosmosandroid.domain.model.Characters

@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "origin") val origin: Int = 0,
    @ColumnInfo(name = "location") val location: Int = 0,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "episode") val episode: Int = 0,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "created") val created: String
)

fun Characters.toDatabase() = CharacterEntity(id = id, name =  name,status = status,
    species = species, type = type, gender = gender, origin = 0, location = 0,
    image = image,episode = 0, url = url, created = created)