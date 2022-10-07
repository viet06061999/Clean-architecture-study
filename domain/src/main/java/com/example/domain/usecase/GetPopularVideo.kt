package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.common.Transformer
import com.example.domain.entities.VideoEntity
import io.reactivex.Observable

class GetPopularVideo(
    transformer: Transformer<List<VideoEntity>>,
    private val videosRepository: VideosRepository
) : UseCase<List<VideoEntity>>(transformer) {

    override fun createObservable(data: Map<String, Any>?): Observable<List<VideoEntity>> {
        val page = data?.get(PARAM_SEARCH_PAGE) ?: return Observable.empty()
        return videosRepository.getPopularVideos(page as? Int ?: 1)
    }
}
