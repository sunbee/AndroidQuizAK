package com.example.androidquiz.ui.knowledgeBase

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun KnowledgeBaseImage(
    imageURI: String
) {
    AsyncImage(
        model = imageURI,
        contentDescription = "Explanatory Image",
        modifier = Modifier
            .size(200.dp)
            .border(
                BorderStroke(4.dp, Color.Yellow),
                CircleShape
            )
            .padding(4.dp)
            .clip(CircleShape)
    )
}