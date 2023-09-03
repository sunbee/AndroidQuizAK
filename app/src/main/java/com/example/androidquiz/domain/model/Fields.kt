package com.example.androidquiz.domain.model

import com.squareup.moshi.Json

data class Fields(
    val qid: Int? = null,
    val question: String? = null,
    val answer: String? = null,
    val category: String? = null,
    val image: ArrayList<Image>? = arrayListOf(),
    val videoUrl: String? = null
)