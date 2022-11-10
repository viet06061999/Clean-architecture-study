package com.example.domain

import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity

interface VideosDataStore {

    interface Local {}

    interface Remote {
        suspend fun getVideoById(movieId: Int): Optional<VideoEntity>
        suspend fun getPopularVideos(page: Int = 1): List<VideoEntity>
        suspend fun search(query: String, page: Int = 1): List<VideoEntity>
    }
}
