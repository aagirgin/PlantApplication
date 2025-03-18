package com.example.hubxapplication.di

import android.content.Context
import androidx.room.Room
import com.example.hubxapplication.data.local.OnboardingDao
import com.example.hubxapplication.data.local.OnboardingDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideOnboardingDao(database: OnboardingDatabase): OnboardingDao {
        return database.onboardingDao()
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): OnboardingDatabase {
        return Room.databaseBuilder(
            context,
            OnboardingDatabase::class.java,
            "app_database_name"
        ).build()
    }
}