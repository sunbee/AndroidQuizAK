package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

data class ThumbnailsDto(
    @field:Json(name="small") val small : SmallDto? = SmallDto(),
    @field:Json(name="large") val large : LargeDto? = LargeDto(),
    @field:Json(name="full") val full  : FullDto?  = FullDto()
)
