package com.example.domain

import com.example.domain.entities.Optional
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.core.Observable

interface VideosDataStore {
    interface Local {}
    interface Remote {
        fun getVideoById(movieId: Int): Observable<Optional<VideoEntity>>
        fun getPopularVideos(page: Int = 1): Observable<List<VideoEntity>>
        fun search(query: String, page: Int = 1): Observable<List<VideoEntity>>
    }
}
