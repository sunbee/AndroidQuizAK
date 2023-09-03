package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

data class ContentsDto(
    @field:Json(name="records" ) val records : ArrayList<RecordsDto> = arrayListOf()
)