package com.example.hubxapplication.presentation.home.state

import com.example.hubxapplication.domain.model.Categories

sealed interface CategoriesUiState {
    data class Success(val data: Categories): CategoriesUiState
    data object Loading: CategoriesUiState
    data class Error(val message: String): CategoriesUiState
}
