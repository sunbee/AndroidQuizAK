package com.example.androidquiz.domain.model

import com.squareup.moshi.Json

data class Thumbnails(
    val small : Small? = Small(),
    val large : Large? = Large(),
    val full  : Full?  = Full()
)
