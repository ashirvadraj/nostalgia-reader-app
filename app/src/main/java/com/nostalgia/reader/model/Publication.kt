package com.nostalgia.reader.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Publication(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("category") val category: String, // MAGAZINE, COMIC, NEWSPAPER
    @SerializedName("series") val series: String,     // Champak, Nandan, Chandamama, etc.
    @SerializedName("year") val year: Int,
    @SerializedName("language") val language: String, // hi, en
    @SerializedName("coverUrl") val coverUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("pages") val pages: List<PageContent>,
    @SerializedName("sourceUrl") val sourceUrl: String = "",
    @SerializedName("isOfflineAvailable") var isOfflineAvailable: Boolean = false
) : Serializable

data class PageContent(
    @SerializedName("pageNumber") val pageNumber: Int,
    @SerializedName("imageUrl") val imageUrl: String? = null,
    @SerializedName("storyTitle") val storyTitle: String? = null,
    @SerializedName("storyText") val storyText: String? = null,
    @SerializedName("illustrationTag") val illustrationTag: String? = null
) : Serializable

data class ReadingProgress(
    @SerializedName("publicationId") val publicationId: String,
    @SerializedName("title") val title: String,
    @SerializedName("lastReadPage") var lastReadPage: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("lastReadTimestamp") var lastReadTimestamp: Long,
    @SerializedName("readingTheme") var readingTheme: String = "PARCHMENT"
) : Serializable
