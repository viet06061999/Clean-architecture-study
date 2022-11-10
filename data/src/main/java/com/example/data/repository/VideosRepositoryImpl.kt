package com.example.data.repository

import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VideosRepositoryImpl(
    private val remote: VideosDataStore.Remote,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : VideosRepository {

    override suspend fun getVideoById(movieId: Int): Optional<VideoEntity> =
        withContext(ioDispatcher) {
            remote.getVideoById(movieId)
        }


    override suspend fun getPopularVideos(page: Int): List<VideoEntity> =
        withContext(ioDispatcher) {
            remote.getPopularVideos(page)
        }

    override suspend fun search(query: String, page: Int): List<VideoEntity> =
        withContext(ioDispatcher) {
            remote.search(query, page)
        }

}
