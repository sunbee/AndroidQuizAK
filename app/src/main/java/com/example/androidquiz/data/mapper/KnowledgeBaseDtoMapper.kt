package com.example.androidquiz.data.mapper

import com.example.androidquiz.data.dto.ContentsDto
import com.example.androidquiz.data.dto.FieldsDto
import com.example.androidquiz.data.dto.FullDto
import com.example.androidquiz.data.dto.ImageDto
import com.example.androidquiz.data.dto.LargeDto
import com.example.androidquiz.data.dto.RecordsDto
import com.example.androidquiz.data.dto.SmallDto
import com.example.androidquiz.data.dto.ThumbnailsDto
import com.example.androidquiz.domain.model.Contents
import com.example.androidquiz.domain.model.Fields
import com.example.androidquiz.domain.model.Full
import com.example.androidquiz.domain.model.Image
import com.example.androidquiz.domain.model.Large
import com.example.androidquiz.domain.model.Records
import com.example.androidquiz.domain.model.Small
import com.example.androidquiz.domain.model.Thumbnails

fun SmallDto.toSmall(): Small {
    return Small(
        url = url,
        width = width,
        height = height
    )
}

fun LargeDto.toLarge(): Large {
    return Large(
        url = url,
        width = width,
        height = height
    )
}

fun FullDto.toFull(): Full {
    return Full(
        url = url,
        width = width,
        height = height
    )
}

fun ThumbnailsDto.toThumbnails(): Thumbnails {
    return Thumbnails(
        small = small?.toSmall(),
        large = large?.toLarge(),
        full = full?.toFull()
    )
}

fun ImageDto.toImage(): Image {
    return Image(
        id = id,
        width = width,
        height = height,
        url = url,
        filename = filename,
        size = size,
        type = type,
        thumbnails = thumbnails?.toThumbnails()
    )
}

fun FieldsDto.toFields(): Fields {
    return Fields(
        qid = qid,
        question = question,
        answer = answer,
        category = category,
        image = image?.mapNotNull { it.toImage() },
        videoUrl = videoUrl
    )
}

fun RecordsDto.toRecords(): Records {
    return Records(
        id = id,
        createdTime = createdTime,
        fields = fields?.toFields()
    )
}

fun ContentsDto.toContents(): Contents {
    return Contents(
        records = records.map { it.toRecords() }
    )
}