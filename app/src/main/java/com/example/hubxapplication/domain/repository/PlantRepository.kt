package com.example.hubxapplication.domain.repository

import com.example.hubxapplication.data.remote.dto.CategoriesDto
import com.example.hubxapplication.data.remote.dto.QuestionsDto

interface PlantRepository {
    suspend fun getCategories(): CategoriesDto

    suspend fun getQuestions(): List<QuestionsDto>
}