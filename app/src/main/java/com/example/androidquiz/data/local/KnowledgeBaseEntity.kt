package com.example.androidquiz.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KnowledgeBaseEntity(
    @PrimaryKey val qid: Int? = null,
    val question: String,
    val answer: String,
    val category: String,
    val thumbnailUrl: String? = null,
    val imageUrl: String? = null,
    val videoUrl: String? = null,
    val startSeconds: Float? = 0f
)
