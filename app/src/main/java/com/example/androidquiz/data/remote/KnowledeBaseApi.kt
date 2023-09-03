package com.example.androidquiz.data.remote

import com.example.androidquiz.data.dto.ContentsDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KnowledeBaseApi {

    @Headers("Authorization: Bearer ${API_KEY}")
    @GET("appymW5iocJTSrDLQ/KnowledgeBase")
    suspend fun getKnowledgeBase(): ContentsDto

    companion object {
        const val API_KEY = "1234"
        const val BASE_URL = "https://api.airtable.com/v0"
    }
}