package com.example.hubxapplication.domain.usecase

import com.example.hubxapplication.common.Resource
import com.example.hubxapplication.data.remote.dto.toCategories
import com.example.hubxapplication.domain.model.Categories
import com.example.hubxapplication.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: PlantRepository
) {
    operator fun invoke(): Flow<Resource<Categories>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getCategories().toCategories()
            emit(Resource.Success(categories))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "Unexpected Error."))
        } catch (e: IOException){
            emit(Resource.Error("Connection Error."))
        }
    }
}