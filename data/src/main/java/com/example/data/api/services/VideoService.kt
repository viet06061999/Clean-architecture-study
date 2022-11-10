package com.example.data.api.services

import com.example.data.api.result_entity.VideoListResult
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {

    @GET("videos/popular")
    suspend fun geVideosPopular(@Query("page") page: Int = 1): VideoListResult

    @GET("videos/search")
    suspend fun searchVideos(
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): VideoListResult
}
