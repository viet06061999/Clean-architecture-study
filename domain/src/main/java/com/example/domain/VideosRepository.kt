package com.example.domain

import com.example.domain.common.Either
import com.example.domain.common.exception.Failure
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.flow.Flow

interface VideosRepository {

    suspend fun getVideoById(movieId: Int): Optional<VideoEntity>
    suspend fun getPopularVideos(page: Int = 1): List<VideoEntity>
    suspend fun search(query: String, page: Int = 1): List<VideoEntity>

    suspend fun insertFavourite(video: VideoEntity): Either<Failure, Boolean>
    fun getFavourites(): Flow<List<VideoEntity>>
    suspend fun deleteFavourite(video: VideoEntity): Either<Failure, Boolean>

}
