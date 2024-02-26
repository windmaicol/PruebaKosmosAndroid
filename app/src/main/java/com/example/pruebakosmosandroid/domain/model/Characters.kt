package com.example.pruebakosmosandroid.domain.model

import com.example.pruebakosmosandroid.data.database.entities.CharacterEntity
import com.example.pruebakosmosandroid.data.model.CharactersModel
import com.example.pruebakosmosandroid.data.model.LocationModel
import com.example.pruebakosmosandroid.data.model.OriginModel

data class Characters (val id:Int, val name:String,val status : String ,
                   val  species: String, val type: String, val gender: String,
                   val origin: OriginModel?, val location: LocationModel?, val image: String,
                   val episode:  List<String>?, val url: String, val created: String)


fun CharactersModel.toDomain() = Characters(id, name,status,species,type,gender,origin,location,
    image, episode,url ,created)

fun CharacterEntity.toDomain() = Characters(id, name,status,species,type,gender,null,null,
    image, null,url ,created)

