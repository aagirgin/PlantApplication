package com.example.hubxapplication.domain.model

data class Questions(
    val id: Int,
    val imageUrl: String,
    val order: Int,
    val subtitle: String,
    val title: String,
    val uri: String
)