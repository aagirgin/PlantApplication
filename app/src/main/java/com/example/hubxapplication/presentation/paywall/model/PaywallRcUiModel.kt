package com.example.hubxapplication.presentation.paywall.model

import androidx.annotation.DrawableRes

data class PaywallRcUiModel(
    val title: String,
    val subTitle: String,
    @DrawableRes val img: Int
)
