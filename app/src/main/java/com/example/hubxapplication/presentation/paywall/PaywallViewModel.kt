package com.example.hubxapplication.presentation.paywall

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubxapplication.R
import com.example.hubxapplication.data.local.OnboardingDao
import com.example.hubxapplication.data.local.model.OnboardingItem
import com.example.hubxapplication.presentation.paywall.model.PaywallRcUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PaywallViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val onboardingDao: OnboardingDao
): ViewModel() {
    fun getData(): List<PaywallRcUiModel> {
        return listOf(
            PaywallRcUiModel(context.getString(R.string.paywall_title1_txt), context.getString(R.string.paywall_title_subtitle1_txt), R.drawable.ic_paywall_rc_1),
            PaywallRcUiModel(context.getString(R.string.paywall_title2_txt), context.getString(R.string.paywall_title_subtitle2_txt), R.drawable.ic_paywall_rc_2),
            PaywallRcUiModel(context.getString(R.string.paywall_title2_txt), context.getString(R.string.paywall_title_subtitle2_txt), R.drawable.ic_paywall_rc_3)
        )
    }

    fun setOnboardingShown() {
        viewModelScope.launch {
            val onboardingItem = OnboardingItem(id = 1, onboardingShown = true)
            onboardingDao.upsertOnboarding(onboardingItem)
        }
    }
}
