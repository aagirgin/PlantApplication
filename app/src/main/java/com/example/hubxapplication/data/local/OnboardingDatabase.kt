package com.example.hubxapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hubxapplication.data.local.model.OnboardingItem


@Database(entities = [OnboardingItem::class], version = 1)
abstract class OnboardingDatabase : RoomDatabase() {
    abstract fun onboardingDao(): OnboardingDao
}