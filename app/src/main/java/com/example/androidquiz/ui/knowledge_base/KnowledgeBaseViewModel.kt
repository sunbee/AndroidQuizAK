package com.example.androidquiz.ui.knowledge_base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.androidquiz.domain.repository.KnowledgeBaseRepository
import com.example.androidquiz.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KnowledgeBaseViewModel @Inject constructor(
    private val knowledgeBaseRepository: KnowledgeBaseRepository
): ViewModel() {

    val state = MutableStateFlow(KnowledgeBaseState())

    init {
        getKnowledgeBase(fetchFromRemote = true)
    }

    fun getKnowledgeBase(
        fetchFromRemote: Boolean = false,
        query: String = ""
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            knowledgeBaseRepository
                .getKnowledgeBase(fetchFromRemote, query)
                .collect() { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { knowledgeBaseItems ->
                                state.value = state.value.copy(
                                    items = knowledgeBaseItems
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state.value = state.value.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
        }
    }

}