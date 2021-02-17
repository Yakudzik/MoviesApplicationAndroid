package com.example.cinematestapp.moviesData


import com.google.gson.annotations.SerializedName

data class Content(
//    @SerializedName("id")
//    val id: Int,
    @SerializedName("title")
    val genre: String,
//    @SerializedName("color")
//    val color: String,
//    @SerializedName("description")
//    val description: Any?,
//    @SerializedName("is_portrait")
//    val isPortrait: Boolean,
//    @SerializedName("position")
//    val position: Int,
    @SerializedName("content")
    val content: List<ContentX>
)