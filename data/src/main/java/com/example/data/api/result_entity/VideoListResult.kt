package com.example.data.api.result_entity

import com.example.data.entities.VideoData
import com.google.gson.annotations.SerializedName

data class VideoListResult(

    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total_results")
    val totalResult: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("videos")
    val videos: List<VideoData>
)
