package com.example.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.common.UseCase
import com.example.domain.usecase.GetFavourites
import com.example.domain.usecase.GetPopularVideo
import com.example.domain.usecase.InsertFavourite
import com.example.presentation.base.RxViewModel
import com.example.presentation.entities.VideoUIEntity
import com.example.presentation.mappers.VideoEntityToUIMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularVideo: GetPopularVideo,
    private val insertFavourite: InsertFavourite,
    private val getFavourites: GetFavourites
) : RxViewModel() {

    private val _videos = MutableLiveData<List<VideoUIEntity>>()
    val videos: LiveData<List<VideoUIEntity>>
        get() = _videos

//    init {
//        getPopularVideos()
//    }

    fun getPopularVideos() {
        viewModelScope.launch {
            val response = getPopularVideo(1)
            response.collectLatest {
                _videos.postValue(it.map {
                    VideoEntityToUIMapper().mapFrom(it)
                })
            }

            val deferreds = listOf(
                async(Dispatchers.IO) {
                    getPopularVideo(1)
                },
                async(Dispatchers.IO) {
                    getPopularVideo(2)
                }
            )
            deferreds.awaitAll()
        }
    }

    fun insertFavourite(videoUI: VideoUIEntity) {
        videoUI.rawVideoEntity?.let {
            insertFavourite(it, viewModelScope)
        }
    }

    fun getFavourites() {
        getFavourites(UseCase.None(), viewModelScope) {
            it.fold(
                {
                    println(it)
                },
                {
                    viewModelScope.launch {
                        it.collectLatest { favourites ->
                            println("favourite:$favourites")
                        }
                    }
                }
            )
        }
    }
}
