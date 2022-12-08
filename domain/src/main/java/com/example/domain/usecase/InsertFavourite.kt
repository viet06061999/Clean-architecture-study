package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.common.Either
import com.example.domain.common.UseCase
import com.example.domain.common.exception.Failure
import com.example.domain.entities.VideoEntity

class InsertFavourite(
    private val videosRepository: VideosRepository
) : UseCase<Boolean, VideoEntity>() {

    override suspend fun run(params: VideoEntity): Either<Failure, Boolean> {
        //do cool stuff here with the url
        //eventually produces a list of ParseResult objects
        return videosRepository.insertFavourite(params)
    }

    companion object {
        private const val PARAM_SEARCH_QUERY = "PARAM_SEARCH_QUERY"
        private const val PARAM_SEARCH_PAGE = "PARAM_SEARCH_PAGE"
    }
}