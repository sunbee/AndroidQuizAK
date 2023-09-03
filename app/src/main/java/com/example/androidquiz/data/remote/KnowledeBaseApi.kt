package com.example.androidquiz.data.remote

import com.example.androidquiz.data.dto.ContentsDto
import com.example.androidquiz.util.AIRTABLE_API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface KnowledeBaseApi {

    @Headers("Authorization: Bearer ${API_KEY}")
    @GET("appymW5iocJTSrDLQ/KnowledgeBase")
    suspend fun getKnowledgeBase(): ContentsDto

    companion object {
        const val API_KEY = AIRTABLE_API_KEY
        const val BASE_URL = "https://api.airtable.com/v0/"
    }
}