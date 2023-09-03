package com.example.androidquiz.domain.model

data class Fields(
    val qid: Int? = null,
    val question: String? = null,
    val answer: String? = null,
    val category: String? = null,
    val image: List<Image>? = listOf<Image>(),
    val videoUrl: String? = null
)