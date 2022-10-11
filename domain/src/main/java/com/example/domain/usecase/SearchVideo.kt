package com.example.domain.usecase

import com.example.domain.VideosRepository
import com.example.domain.common.Transformer
import com.example.domain.entities.VideoEntity
import io.reactivex.rxjava3.core.Observable

class SearchVideo(
    transformer: Transformer<List<VideoEntity>>,
    private val videosRepository: VideosRepository
) :
    UseCase<List<VideoEntity>>(transformer) {

    fun search(query: String, page: Int): Observable<List<VideoEntity>> {
        val data = HashMap<String, Any>()
        data[PARAM_SEARCH_PAGE] = page
        data[PARAM_SEARCH_QUERY] = query
        return createObservable(data)
    }

    override fun createObservable(data: Map<String, Any>?): Observable<List<VideoEntity>> {
        val query = data?.get(PARAM_SEARCH_QUERY) ?: return Observable.empty()
        val page = data[PARAM_SEARCH_PAGE] ?: return Observable.empty()
        return videosRepository.search(query as String, page as Int)
    }

    companion object {
        private const val PARAM_SEARCH_QUERY = "PARAM_SEARCH_QUERY"
        private const val PARAM_SEARCH_PAGE = "PARAM_SEARCH_PAGE"
    }
}