package com.example.androidquiz.ui.knowledgeBase

sealed class KnowledgeBaseEvent {
    object OnClickedShowAnswer: KnowledgeBaseEvent()
    object OnClickedSpotOn: KnowledgeBaseEvent()
    object OnClickedPartial: KnowledgeBaseEvent()
    object OnClickedIncorrect: KnowledgeBaseEvent()
}
