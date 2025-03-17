package com.example.hubxapplication.presentation.home.state

import com.example.hubxapplication.domain.model.Questions

sealed interface QuestionsUiState {
    data class Success(val data: List<Questions>): QuestionsUiState
    data object Loading: QuestionsUiState
    data class Error(val message: String): QuestionsUiState
}
