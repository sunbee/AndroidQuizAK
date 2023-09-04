package com.example.androidquiz.ui.knowledge_base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun KnowledgeBaseScreen(
    viewModel: KnowledgeBaseViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    state.value.items?.let {
        if (it.isNotEmpty()) {
            Text(text=it[0]?.question ?: "How are you?")
        }
    }
    //Text(text = state.value.contents.toString())

}