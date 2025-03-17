package com.example.hubxapplication.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hubxapplication.common.Resource
import com.example.hubxapplication.domain.usecase.GetCategoriesUseCase
import com.example.hubxapplication.domain.usecase.GetQuestionsUseCase
import com.example.hubxapplication.presentation.home.state.CategoriesUiState
import com.example.hubxapplication.presentation.home.state.QuestionsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
): ViewModel() {

    private val _questionsUiState = MutableStateFlow<QuestionsUiState>(QuestionsUiState.Loading)
    val questionsUiState get() = _questionsUiState.asStateFlow()

    private val _categoriesUiState = MutableStateFlow<CategoriesUiState>(CategoriesUiState.Loading)
    val categoriesUiState get() = _categoriesUiState.asStateFlow()


    init {
        getQuestionsData()
        getCategoriesData()
    }

    private fun getQuestionsData() {
        viewModelScope.launch {
            getQuestionsUseCase.invoke().collect  { result ->
                when (result) {
                    is Resource.Success -> {
                        _questionsUiState.emit(QuestionsUiState.Success(data = result.data ?: emptyList()))
                    }
                    is Resource.Error -> {
                        _questionsUiState.emit(QuestionsUiState.Error(message = result.message ?: "Unexpected error occurred."))
                    }
                    is Resource.Loading -> {
                        _questionsUiState.emit(QuestionsUiState.Loading)
                    }
                }
            }
        }
    }

    private fun getCategoriesData() {
        viewModelScope.launch {
            getCategoriesUseCase.invoke().collect  { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let { CategoriesUiState.Success(data = it) }?.let { _categoriesUiState.emit(it) }
                    }
                    is Resource.Error -> {
                        _categoriesUiState.emit(CategoriesUiState.Error(message = result.message ?: "Unexpected error occurred."))
                    }
                    is Resource.Loading -> {
                        _categoriesUiState.emit(CategoriesUiState.Loading)
                    }
                }
            }
        }
    }
}