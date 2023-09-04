package com.example.androidquiz.ui.knowledgeBase

import com.example.androidquiz.domain.model.KnowledgeBaseItem

data class KnowledgeBaseState(
    val items: List<KnowledgeBaseItem> = emptyList(),
    val currentIndex: Int = 0,
    val showQuestionOnly: Boolean = true,
    val isLoading: Boolean = false
)
