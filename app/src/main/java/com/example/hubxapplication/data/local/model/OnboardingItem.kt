package com.example.hubxapplication.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OnboardingItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val onboardingShown: Boolean
)