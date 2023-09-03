package com.example.androidquiz.data.dto

import com.squareup.moshi.Json

class RecordsDto(
    @field:Json(name="id") val id: String? = null,
    @field:Json(name="createdTime") val createdTime : String? = null,
    @field:Json(name="fields") val fields: FieldsDto? = FieldsDto()
)