package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.entities.VideoEntity

class SearchVideo(
    private val videosRepository: VideosRepository
) {

    suspend fun search(query: String, page: Int): List<VideoEntity> {
        return videosRepository.search(query, page)
    }

    companion object {
        private const val PARAM_SEARCH_QUERY = "PARAM_SEARCH_QUERY"
        private const val PARAM_SEARCH_PAGE = "PARAM_SEARCH_PAGE"
    }
}