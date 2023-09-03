package com.example.androidquiz.domain.model

import com.squareup.moshi.Json

data class Contents(
    val records : ArrayList<Records> = arrayListOf()
)