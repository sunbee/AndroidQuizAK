package com.example.androidquiz.domain.model

import com.squareup.moshi.Json

class Records(
    val id: String? = null,
    val createdTime : String? = null,
    val fields: Fields? = Fields()
)