package com.example.hubxapplication.presentation.onboarding

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubxapplication.R
import com.example.hubxapplication.common.Resource
import com.example.hubxapplication.domain.usecase.GetQuestionsUseCase
import com.example.hubxapplication.presentation.onboarding.model.OnboardingUiModel
import com.example.hubxapplication.presentation.onboarding.state.OnboardingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    fun getData(): List<OnboardingUiModel> {
        return listOf(
            OnboardingUiModel(
                title =  context.getString(R.string.onboarding_title1_txt),
                img = R.drawable.ic_onboarding_1
            ),
            OnboardingUiModel(
                title = context.getString(R.string.onboarding_title1_txt),
                img = R.drawable.ic_onboarding_2
            ),
            OnboardingUiModel(
                title = context.getString(R.string.onboarding_title2_txt),
                img = R.drawable.ic_onboarding_3
            )
        )
    }
}