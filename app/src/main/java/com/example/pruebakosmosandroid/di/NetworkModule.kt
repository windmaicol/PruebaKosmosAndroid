package com.example.pruebakosmosandroid.di

import com.example.pruebakosmosandroid.BuildConfig
import com.example.pruebakosmosandroid.data.network.TMDBApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBApiClient(retrofit: Retrofit): TMDBApiClient {
        return retrofit.create(TMDBApiClient::class.java)
    }

}