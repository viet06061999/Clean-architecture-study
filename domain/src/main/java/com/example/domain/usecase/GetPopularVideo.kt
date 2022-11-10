package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPopularVideo(
    private val videosRepository: VideosRepository
) {

    operator fun invoke(page: Int): Flow<List<VideoEntity>> = flow {
        emit(videosRepository.getPopularVideos(page))
    }
}
