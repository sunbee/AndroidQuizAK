package com.example.androidquiz.domain.repository

import com.example.androidquiz.domain.model.Contents
import com.example.androidquiz.domain.model.KnowledgeBaseItem
import com.example.androidquiz.util.Resource
import kotlinx.coroutines.flow.Flow

interface KnowledgeBaseRepository {

    suspend fun getKnowledgeBase(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<KnowledgeBaseItem>>>
}