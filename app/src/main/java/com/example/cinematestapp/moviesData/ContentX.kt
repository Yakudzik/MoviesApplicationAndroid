package com.example.cinematestapp.moviesData


import com.google.gson.annotations.SerializedName

data class ContentX(
//    @SerializedName("id")
//    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("cover")
    val cover: Cover?,
//    @SerializedName("episodes")
//    val episodes: Episodes,
//    @SerializedName("genre_id")
//    val genreId: Int,
//    @SerializedName("years_production")
//    val yearsProduction: String,
//    @SerializedName("count_episodes")
//    val countEpisodes: Int,
//    @SerializedName("format")
//    val format: String,
//    @SerializedName("duration")
//    val duration: String,
    @SerializedName("created_at")
    val createdAt: String,
//    @SerializedName("updated_at")
//    val updatedAt: String,
    @SerializedName("languages")
    val languages: List<Language>,
    @SerializedName("genre")
    val genre: Genre
)