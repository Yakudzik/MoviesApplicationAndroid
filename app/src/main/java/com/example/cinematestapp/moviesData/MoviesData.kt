package com.example.cinematestapp.moviesData


import com.google.gson.annotations.SerializedName

data class Movies(
    val result: List<MoviesData>)

data class MoviesData(
    @SerializedName("content")
    val content: List<Content>,

    )