package com.example.data.datastore.remote

import com.example.data.api.services.VideoService
import com.example.data.mappers.data_to_entity.VideoDataEntityMapper
import com.example.domain.VideosDataStore
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.core.Observable

class VideosRemoteDataStore(
    private val api: VideoService
) : VideosDataStore.Remote {
    override fun getVideoById(movieId: Int): Observable<Optional<VideoEntity>> {
        return Observable.empty()
    }

    override fun getPopularVideos(page: Int): Observable<List<VideoEntity>> {
        return api.geVideosPopular(page).map {
            println("ThreadAAA:" + Thread.currentThread().name)
            it.videos.map { videoData ->
                VideoDataEntityMapper().mapFrom(videoData)
            }
        }
    }

    override fun search(query: String, page: Int): Observable<List<VideoEntity>> {
        return api.searchVideos(query, page).map {
            it.videos.map { videoData ->
                VideoDataEntityMapper().mapFrom(videoData)
            }
        }
    }
}