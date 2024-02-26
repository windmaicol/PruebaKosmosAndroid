package com.example.pruebakosmosandroid.di

import android.content.Context
import androidx.room.Room
import com.example.pruebakosmosandroid.data.database.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val TMDB_DATABASE_NAME = "Kosmos_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TMDBDatabase::class.java, TMDB_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideRecoemdationMoviesDao(db: TMDBDatabase) = db.getCharacterDao()
}