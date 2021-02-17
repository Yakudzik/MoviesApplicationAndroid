package com.example.cinematestapp.moviesData


import com.google.gson.annotations.SerializedName

data class Cover(
//    @SerializedName("host")
//    val host: String,
//    @SerializedName("status")
//    val status: Int,
//    @SerializedName("real_type")
//    val realType: String,
//    @SerializedName("width")
//    val width: Int,
//    @SerializedName("original_ext")
//    val originalExt: String,
//    @SerializedName("ready")
//    val ready: Int,
//    @SerializedName("height")
//    val height: Int,
//    @SerializedName("error")
//    val error: Int,
//    @SerializedName("duration")
//    val duration: Int,
    @SerializedName("id")
    val id: String,
//    @SerializedName("ready_full")
//    val readyFull: Int
){
    val createImageURL get() =  "https://signalmediacorp.com//b/c/$id.jpg"
}