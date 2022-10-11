package com.example.data

import com.example.domain.VideosRepository
import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.core.Observable


class Impl : VideosRepository{

    override fun getVideoById(movieId: Int): Observable<Optional<VideoEntity>> {
        TODO("Not yet implemented")
    }

    override fun getPopularVideos(page: Int): Observable<List<VideoEntity>> {
        TODO("Not yet implemented")
    }

    override fun search(query: String, page: Int): Observable<List<VideoEntity>> {
        TODO("Not yet implemented")
    }

}