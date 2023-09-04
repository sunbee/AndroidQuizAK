package com.example.androidquiz.ui.knowledge_base

import com.example.androidquiz.domain.model.Contents
import com.example.androidquiz.domain.model.KnowledgeBaseItem

data class KnowledgeBaseState(
    val items: List<KnowledgeBaseItem> = emptyList(),
    val isLoading: Boolean = false
)
