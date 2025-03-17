package com.example.hubxapplication.domain.model

import com.google.gson.annotations.SerializedName


data class Questions(
    val id: Int,
    val imageUrl: String,
    val order: Int,
    val subtitle: String,
    val title: String,
    val uri: String
)