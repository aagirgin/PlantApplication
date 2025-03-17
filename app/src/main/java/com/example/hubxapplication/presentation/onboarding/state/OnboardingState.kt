package com.example.hubxapplication.presentation.onboarding.state

import com.example.hubxapplication.domain.model.Questions



sealed interface OnboardingUiState {
    data class Success(val data: List<Questions>): OnboardingUiState
    data object Loading: OnboardingUiState
    data class Error(val message: String): OnboardingUiState
}
