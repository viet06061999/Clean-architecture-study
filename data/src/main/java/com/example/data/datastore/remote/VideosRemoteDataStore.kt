package com.example.data.datastore.remote

import com.example.data.api.services.VideoService
import com.example.data.mappers.data_to_entity.VideoDataEntityMapper
import com.example.domain.VideosDataStore
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity

class VideosRemoteDataStore(
    private val api: VideoService
) : VideosDataStore.Remote {

    override suspend fun getVideoById(movieId: Int): Optional<VideoEntity> {
        return Optional.empty()
    }

    override suspend fun getPopularVideos(page: Int): List<VideoEntity> {
        return api.geVideosPopular(page).videos.map {
            VideoDataEntityMapper().mapFrom(it)
        }
    }

    override suspend fun search(query: String, page: Int): List<VideoEntity> {
        return api.searchVideos(query, page).videos.map {
            VideoDataEntityMapper().mapFrom(it)
        }
    }
}