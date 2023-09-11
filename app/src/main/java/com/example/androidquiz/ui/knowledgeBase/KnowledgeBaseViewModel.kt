package com.example.androidquiz.ui.knowledgeBase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidquiz.domain.repository.KnowledgeBaseRepository
import com.example.androidquiz.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KnowledgeBaseViewModel @Inject constructor(
    private val knowledgeBaseRepository: KnowledgeBaseRepository
): ViewModel() {

    val state = MutableStateFlow(KnowledgeBaseState())

    init {
        /* TEST
        *
        * val query = "MVVM Todo List"
        *
        * */

        /* TODO:
        * Pass the query parameter from topics screen
        * where user selects a topic from the list of topics.
        * Retrieve here as SavedStateHandle.
        * */
        val query = "MVVM Stock Market Tracker"
        getKnowledgeBase(fetchFromRemote = true, query = query)
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
                    }  // end WHEN
                }  // end COLLECT RESULT
        }  // end COROUTINE
    }  // end FUN GETKNOWLEDGEBASE

    fun advanceIndex() {
        var presentIndex = state.value.currentIndex
        if (presentIndex < state.value.items.size-1) {
            presentIndex += 1
        } else {
            presentIndex = 0
        }
        state.value = state.value.copy(
            currentIndex = presentIndex,
            showQuestionOnly = true)
    }

    fun displayAnswer() {
        state.value = state.value.copy(showQuestionOnly = false)
    }

    fun onEvent(event: KnowledgeBaseEvent) {
        when (event) {
            is KnowledgeBaseEvent.OnClickedShowAnswer -> {
                displayAnswer()
            }
            is KnowledgeBaseEvent.OnClickedSpotOn -> {
                advanceIndex()
            }
            is KnowledgeBaseEvent.OnClickedPartial -> {
                advanceIndex()
            }
            is KnowledgeBaseEvent.OnClickedIncorrect -> {
                advanceIndex()
            }
            else -> Unit
        }
    }
}