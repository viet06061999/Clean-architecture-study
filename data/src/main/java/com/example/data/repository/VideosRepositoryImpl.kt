package com.example.data.repository

import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import com.example.domain.common.Either
import com.example.domain.common.exception.Failure
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class VideosRepositoryImpl(
    private val remote: VideosDataStore.Remote,
    private val local: VideosDataStore.Local,
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

    override suspend fun insertFavourite(video: VideoEntity): Either<Failure, Boolean> {
        return withContext(ioDispatcher) {
            local.insertFavourite(video)
        }
    }

    override fun getFavourites(): Flow<List<VideoEntity>> {
        return local.getFavourites().flowOn(ioDispatcher)
    }

    override suspend fun deleteFavourite(video: VideoEntity): Either<Failure, Boolean> {
        return withContext(ioDispatcher) {
            local.deleteFavourite(video)
        }
    }
}
