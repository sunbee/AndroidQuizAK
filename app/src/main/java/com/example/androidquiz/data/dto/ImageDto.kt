package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

data class ImageDto(
    @field:Json(name="id") val id: String,
    @field:Json(name="width") val width: Int,
    @field:Json(name="height") val height: Int,
    @field:Json(name="url") val url: String,
    @field:Json(name="filename") val filename: String,
    @field:Json(name="size") val size: Int,
    @field:Json(name="type") val type: String,
    @field:Json(name="thumbnails") val thumbnails: ThumbnailsDto? = ThumbnailsDto()
)
