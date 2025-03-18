package com.example.hubxapplication.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubxapplication.data.local.OnboardingDao
import com.example.hubxapplication.data.local.model.OnboardingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val onboardingDao: OnboardingDao
): ViewModel() {
    private val _onboardingStatus = MutableStateFlow<Boolean?>(null)
    val onboardingStatus: StateFlow<Boolean?> get() = _onboardingStatus

    init {
        loadOnboardingStatus()
    }

    private fun loadOnboardingStatus() {
        viewModelScope.launch {
            val status = onboardingDao.getOnboardingShown() ?: run {
                val onboardingItem = OnboardingItem(id = 1, onboardingShown = false)
                onboardingDao.upsertOnboarding(onboardingItem)
                false
            }
            _onboardingStatus.value = status
        }
    }
}