package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

data class LargeDto(
    @field:Json(name="url") val url: String? = null,
    @field:Json(name="width") val width: Int? = null,
    @field:Json(name="height") val height: Int? = null
)
