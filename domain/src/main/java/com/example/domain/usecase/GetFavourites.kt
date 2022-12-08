package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.common.Either
import com.example.domain.common.UseCase
import com.example.domain.common.exception.Failure
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.flow.Flow

class GetFavourites(
    private val videosRepository: VideosRepository
) : UseCase<Flow<List<VideoEntity>>, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, Flow<List<VideoEntity>>> {
        return try {
            Either.Right(videosRepository.getFavourites())
        } catch (e: Throwable) {
            Either.Left(Failure.DBError(e))
        }
    }
}
