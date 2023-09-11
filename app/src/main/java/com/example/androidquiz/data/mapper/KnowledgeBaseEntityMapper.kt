package com.example.androidquiz.data.mapper

import com.example.androidquiz.data.local.KnowledgeBaseEntity
import com.example.androidquiz.domain.model.KnowledgeBaseItem
import com.example.androidquiz.domain.model.Records

/*
* Map between DB entity and domain model (and vice-versa).
* Use in the repository impl. to convert DB records to view model objects.
* */
fun KnowledgeBaseEntity.toKnowledgeBaseItem(): KnowledgeBaseItem {
    return KnowledgeBaseItem(
        question = question,
        answer = answer,
        category = category,
        thumbnailUrl = thumbnailUrl,
        imageUrl = imageUrl,
        videoUrl = videoUrl,
        startSeconds = startSeconds
    )
}

fun KnowledgeBaseItem.toKnowledgeBaseItemEntity(): KnowledgeBaseEntity {
    return KnowledgeBaseEntity(
        question = question,
        answer = answer,
        category = category,
        thumbnailUrl = thumbnailUrl,
        imageUrl = imageUrl,
        videoUrl = videoUrl,
        startSeconds = startSeconds
    )
}

/*
* Map from DTO to DB
* Use in repository for caching Rest API response to DB.
* */
fun Records.toKnowledgeBaseEntity(): KnowledgeBaseEntity {
    return fields!!.let { fields ->
         KnowledgeBaseEntity(
            question = fields.question!!,
            answer = fields.answer!!,
            category = fields.category!!,
            thumbnailUrl = fields.image?.getOrNull(0)?.thumbnails?.small?.url,
            imageUrl = fields.image?.getOrNull(0)?.url,
            videoUrl = fields.videoUrl,
             startSeconds = fields.startSeconds
        )
    }
}