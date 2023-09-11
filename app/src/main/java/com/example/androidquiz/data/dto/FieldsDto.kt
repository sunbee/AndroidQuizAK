package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

data class FieldsDto(
    @field:Json(name="qid") val qid: Int? = null,
    @field:Json(name="question") val question: String? = null,
    @field:Json(name="answer") val answer: String? = null,
    @field:Json(name="category") val category: String? = null,
    @field:Json(name="image") val image: List<ImageDto>? = listOf<ImageDto>(),
    @field:Json(name="video_url") val videoUrl: String? = null,
    @field:Json(name="start") val startSeconds: Float? = 0f
)