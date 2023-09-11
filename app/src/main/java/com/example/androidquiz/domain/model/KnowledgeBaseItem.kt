package com.example.androidquiz.domain.model

import androidx.room.PrimaryKey

data class KnowledgeBaseItem(
    val question: String,
    val answer: String,
    val category: String,
    val thumbnailUrl: String? = null,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val startSeconds: Float? = 0f
)
