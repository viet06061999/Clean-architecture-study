package com.example.data.repository

import com.example.domain.VideosDataStore
import com.example.domain.VideosRepository
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.core.Observable

class VideosRepositoryImpl(private val remote: VideosDataStore.Remote) : VideosRepository {

    override fun getVideoById(movieId: Int): Observable<Optional<VideoEntity>> {
        return Observable.empty()
    }

    override fun getPopularVideos(page: Int): Observable<List<VideoEntity>> {
        return remote.getPopularVideos(page)
    }

    override fun search(query: String, page: Int): Observable<List<VideoEntity>> {
        return remote.search(query, page)
    }
}