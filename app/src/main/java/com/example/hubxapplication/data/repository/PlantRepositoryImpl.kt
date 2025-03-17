package com.example.hubxapplication.data.repository

import com.example.hubxapplication.data.remote.HubxApi
import com.example.hubxapplication.data.remote.dto.CategoriesDto
import com.example.hubxapplication.data.remote.dto.QuestionsDto
import com.example.hubxapplication.domain.repository.PlantRepository
import javax.inject.Inject

class PlantRepositoryImpl @Inject constructor(
    private val api: HubxApi
): PlantRepository {
    override suspend fun getCategories(): CategoriesDto {
        return api.getCategories()
    }

    override suspend fun getQuestions(): List<QuestionsDto> {
        try {
            val response = api.getQuestions()  // Make the API request
            println("Response: $response")  // Log the response
            return response
        } catch (e: Exception) {
            println("Error occurred: ${e.localizedMessage}")  // Log error if something goes wrong
            throw e
        }
    }
}