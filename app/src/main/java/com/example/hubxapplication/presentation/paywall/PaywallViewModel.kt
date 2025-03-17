package com.example.hubxapplication.presentation.paywall

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.hubxapplication.R
import com.example.hubxapplication.presentation.paywall.model.PaywallRcUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class PaywallViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {
    fun getData(): List<PaywallRcUiModel> {
        return listOf(
            PaywallRcUiModel(context.getString(R.string.paywall_title1_txt), context.getString(R.string.paywall_title_subtitle1_txt), R.drawable.ic_paywall_rc_1),
            PaywallRcUiModel(context.getString(R.string.paywall_title2_txt), context.getString(R.string.paywall_title_subtitle2_txt), R.drawable.ic_paywall_rc_2),
            PaywallRcUiModel(context.getString(R.string.paywall_title2_txt), context.getString(R.string.paywall_title_subtitle2_txt), R.drawable.ic_paywall_rc_3)
        )
    }
}
