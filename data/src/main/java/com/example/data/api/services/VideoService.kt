package com.example.data.api.services

import com.example.data.api.result_entity.VideoListResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {

    @GET("videos/popular")
    fun geVideosPopular(@Query("page") page: Int = 1): Observable<VideoListResult>

    @GET("videos/search")
    fun searchVideos(
        @Query("query") query: String,
        @Query("page") page: Int = 1
    ): Observable<VideoListResult>
}
