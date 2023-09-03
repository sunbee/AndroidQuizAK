package com.example.androidquiz.di

import com.example.androidquiz.data.repository.KnowledgeBaseRepositoryImpl
import com.example.androidquiz.domain.repository.KnowledgeBaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindKnowledgeBaseRepository(
        knowledgeBaseRepositoryImpl: KnowledgeBaseRepositoryImpl
    ): KnowledgeBaseRepository
}
