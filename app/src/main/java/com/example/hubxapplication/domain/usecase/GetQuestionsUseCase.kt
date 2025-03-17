package com.example.hubxapplication.domain.usecase

import com.example.hubxapplication.common.Resource
import com.example.hubxapplication.data.remote.dto.toQuestions
import com.example.hubxapplication.domain.model.Questions
import com.example.hubxapplication.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(
    private val repository: PlantRepository
) {
    operator fun invoke(): Flow<Resource<List<Questions>>> = flow {
        try {
            println("OnBoardingFragment IN")

            emit(Resource.Loading())
            val questions = repository.getQuestions().map {
                it.toQuestions()
            }
            emit(Resource.Success(questions))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "Unexpected Error."))
        } catch (e: IOException){
            emit(Resource.Error("Connection Error."))
        }
    }
}