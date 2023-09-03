package com.example.androidquiz.ui.knowledge_base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidquiz.domain.repository.KnowledgeBaseRepository
import com.example.androidquiz.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
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
        getKnowledgeBase()
    }

    fun getKnowledgeBase() {
        viewModelScope.launch {
            knowledgeBaseRepository
                .getKnowledgeBase()
                .collect() { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { contents ->
                                state.value = state.value.copy(
                                    contents = contents
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