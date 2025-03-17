package com.example.hubxapplication.data.remote.dto


import com.example.hubxapplication.domain.model.Categories
import com.example.hubxapplication.domain.model.CategoriesData
import com.example.hubxapplication.domain.model.CategoriesImage
import com.example.hubxapplication.domain.model.CategoriesMeta
import com.example.hubxapplication.domain.model.CategoriesPagination
import com.example.hubxapplication.domain.model.Questions
import com.google.gson.annotations.SerializedName


data class CategoriesDto (
    @SerializedName("data")
    val data : List<DataDto>,
    @SerializedName("meta")
    val meta : MetaDto?
)


data class ImageDto (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("alternativeText")
    val alternativeText: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("formats")
    val formats: String?,
    @SerializedName("hash")
    val hash: String?,
    @SerializedName("ext")
    val ext: String?,
    @SerializedName("mime")
    val mime: String?,
    @SerializedName("size")
    val size: Double?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("previewUrl")
    val previewUrl: String?,
    @SerializedName("provider")
    val provider: String?,
    @SerializedName("provider_metadata")
    val providerMetadata : String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?
)

data class DataDto (
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("createdAt")
    val createdAt : String?,
    @SerializedName("updatedAt")
    val updatedAt : String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("image")
    val image: ImageDto
)

data class Pagination (
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pageSize")
    val pageSize: Int?,
    @SerializedName("pageCount")
    val pageCount: Int?,
    @SerializedName("total")
    val total: Int?
)

data class MetaDto (
    @SerializedName("pagination")
    val pagination: Pagination?
)

fun CategoriesDto.toCategories(): Categories {
    return Categories(
        data = data.map { it.toCategoriesData() },
        meta = meta?.toCategoriesMeta()
    )
}

fun DataDto.toCategoriesData(): CategoriesData {
    return CategoriesData(
        id = id,
        name = name,
        createdAt = createdAt,
        updatedAt = updatedAt,
        publishedAt = publishedAt,
        title = title,
        rank = rank,
        image = image.toCategoriesImage()
    )
}

fun ImageDto.toCategoriesImage(): CategoriesImage {
    return CategoriesImage(
        id = id,
        name = name,
        alternativeText = alternativeText,
        caption = caption,
        width = width,
        height = height,
        formats = formats,
        hash = hash,
        ext = ext,
        mime = mime,
        size = size,
        url = url,
        previewUrl = previewUrl,
        provider = provider,
        providerMetadata = providerMetadata,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun MetaDto.toCategoriesMeta(): CategoriesMeta {
    return CategoriesMeta(
        pagination = pagination?.toCategoriesPagination()
    )
}

fun Pagination.toCategoriesPagination(): CategoriesPagination {
    return CategoriesPagination(
        page = page,
        pageSize = pageSize,
        pageCount = pageCount,
        total = total
    )
}
