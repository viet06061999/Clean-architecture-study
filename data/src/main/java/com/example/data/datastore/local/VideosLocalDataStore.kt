package com.example.data.datastore.local

import com.example.data.datastore.local.db.dao.VideoDao
import com.example.data.entities.VideoSaveData
import com.example.data.mappers.data_to_entity.VideoDataEntityMapper
import com.example.data.mappers.entity_to_data.VideoEntityDataMapper
import com.example.domain.VideosDataStore
import com.example.domain.common.Either
import com.example.domain.common.exception.Failure
import com.example.domain.entities.VideoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class VideosLocalDataStore(
    private val dao: VideoDao
) : VideosDataStore.Local {

    override suspend fun insertFavourite(video: VideoEntity): Either<Failure, Boolean> {
        return try {
            dao.insertFavourite(
                VideoSaveData.fromVideoData(
                    VideoEntityDataMapper().mapFrom(video).getSaveData()
                )
            )
            Either.Right(true)
        } catch (e: Throwable) {
            Either.Left(Failure.DBError(e))
        }
    }

    override fun getFavourites(): Flow<List<VideoEntity>> {
        return dao.getFavourites().map {
            it.map { videoSaveData ->
                VideoDataEntityMapper().mapFrom(videoSaveData.toVideoData())
            }
        }
    }

    override suspend fun deleteFavourite(video: VideoEntity): Either<Failure, Boolean> {
        return try {
            dao.deleteFavourite(
                VideoSaveData.fromVideoData(
                    VideoEntityDataMapper().mapFrom(video).getSaveData()
                )
            )
            Either.Right(true)
        } catch (e: Throwable) {
            Either.Left(Failure.DBError(e))
        }
    }
}