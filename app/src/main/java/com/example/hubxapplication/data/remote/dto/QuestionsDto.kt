package com.example.hubxapplication.data.remote.dto

import com.example.hubxapplication.domain.model.Questions
import com.google.gson.annotations.SerializedName

data class QuestionsDto(
    val id: Int,
    @SerializedName("image_uri")
    val imageUri: String,
    val order: Int,
    val subtitle: String,
    val title: String,
    val uri: String
)


fun QuestionsDto.toQuestions(): Questions {
    return Questions(
        id = id ?: -1,
        imageUrl = imageUri.orEmpty(),
        order = order ?: -1,
        subtitle = subtitle.orEmpty(),
        title = title.orEmpty(),
        uri = uri.orEmpty()
    )
}