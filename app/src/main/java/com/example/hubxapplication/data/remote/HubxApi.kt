package com.example.hubxapplication.data.remote

import com.example.hubxapplication.data.remote.dto.CategoriesDto
import com.example.hubxapplication.data.remote.dto.QuestionsDto
import retrofit2.http.GET

interface HubxApi{
    @GET("/getCategories")
    suspend fun getCategories(): CategoriesDto

    @GET("/getQuestions")
    suspend fun getQuestions(): List<QuestionsDto>
}