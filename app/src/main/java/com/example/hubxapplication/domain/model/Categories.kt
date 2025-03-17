package com.example.hubxapplication.domain.model


data class Categories (
    val data : List<CategoriesData>,
    val meta : CategoriesMeta?
)


data class CategoriesImage (
    val id: Int?,
    val name: String?,
    val alternativeText: String?,
    val caption: String?,
    val width: Int?,
    val height: Int?,
    val formats: String?,
    val hash: String?,
    val ext: String?,
    val mime: String?,
    val size: Double?,
    val url: String?,
    val previewUrl: String?,
    val provider: String?,
    val providerMetadata : String?,
    val createdAt: String?,
    val updatedAt: String?
)

data class CategoriesData (
    val id: Int?,
    val name: String?,
    val createdAt : String?,
    val updatedAt : String?,
    val publishedAt: String?,
    val title: String?,
    val rank: Int?,
    val image: CategoriesImage
)

data class CategoriesPagination (
    val page: Int?,
    val pageSize: Int?,
    val pageCount: Int?,
    val total: Int?
)

data class CategoriesMeta (
    val pagination: CategoriesPagination?
)
