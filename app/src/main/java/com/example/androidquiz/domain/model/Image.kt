package com.example.androidquiz.domain.model

data class Image(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val filename: String,
    val size: Int,
    val type: String,
    val thumbnails: Thumbnails? = Thumbnails()
)
