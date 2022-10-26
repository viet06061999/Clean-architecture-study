package com.example.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.usecase.GetPopularVideo
import com.example.domain.usecase.UseCase
import com.example.presentation.base.RxViewModel
import com.example.presentation.entities.VideoUIEntity
import com.example.presentation.mappers.VideoEntityToUIMapper
import io.reactivex.rxjava3.kotlin.addTo

class HomeViewModel(private val getPopularVideo: GetPopularVideo) : RxViewModel() {

    private val _videos = MutableLiveData<List<VideoUIEntity>>()
    val videos: LiveData<List<VideoUIEntity>>
        get() = _videos

    init {
        getPopularVideos()
    }

    fun getPopularVideos() {
        getPopularVideo
            .observable(hashMapOf(UseCase.PARAM_SEARCH_PAGE to 1))
            .doOnSubscribe {
                _isLoading.postValue(true)
            }
            .doOnTerminate {
                _isLoading.postValue(false)
            }
            .subscribe({ videoEntities ->
                _videos.postValue(videoEntities.map {
                    VideoEntityToUIMapper().mapFrom(it)
                })
            },
                {
                    it.printStackTrace()
                }).addTo(disposables)
    }
}