package com.example.domain.entities

data class VideoEntity(
    var id: Int = -1,
    var width: Int = -1,
    var height: Int = -1,
    var url: String = "",
    var image: String = "",
    var duration: Int = -1,
    var user: UserEntity = UserEntity(),
    var videoFiles: List<VideoFileEntity> = arrayListOf(),
    var videoPictures: List<VideoPictureEntity> = arrayListOf()
)
