package com.example.androidquiz.di

import android.app.Application
import androidx.room.Room
import com.example.androidquiz.data.local.KnowledgeBaseDatabase
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
    fun getKnowledgeBaseDatabase(app: Application): KnowledgeBaseDatabase {
        return Room.databaseBuilder(
            app,
            KnowledgeBaseDatabase::class.java,
            "knowledgedb"
        ).fallbackToDestructiveMigration().build()
    }

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
