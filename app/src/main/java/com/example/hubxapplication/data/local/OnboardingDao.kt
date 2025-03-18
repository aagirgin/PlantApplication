package com.example.hubxapplication.data.local

import androidx.room.Dao

import androidx.room.Query
import androidx.room.Upsert
import com.example.hubxapplication.data.local.model.OnboardingItem

@Dao
interface OnboardingDao {

    @Upsert
    suspend fun upsertOnboarding(onboardingItem: OnboardingItem)


    @Query("SELECT onboardingShown FROM OnboardingItem WHERE id = 1")
    suspend fun getOnboardingShown(): Boolean?
}