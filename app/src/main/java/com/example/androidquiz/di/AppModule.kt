package com.example.androidquiz.di

import com.example.androidquiz.data.remote.KnowledeBaseApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getKnowledgeBaseApi(): KnowledeBaseApi {
        return Retrofit.Builder()
            .baseUrl(KnowledeBaseApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}
