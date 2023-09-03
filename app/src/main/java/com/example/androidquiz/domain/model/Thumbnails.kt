package com.example.androidquiz.domain.model

data class Thumbnails(
    val small : Small? = Small(),
    val large : Large? = Large(),
    val full  : Full?  = Full()
)
