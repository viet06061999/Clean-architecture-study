package com.example.domain.entities

data class VideoEntity(
    var id: Int = -1,
    var width: Int = -1,
    var height: Int = -1,
    var url: String = "",
    var image: String = "",
    var fullRes: String = "",
    var tags: ArrayList<String> = arrayListOf(),
    var duration: Int? = null,
    var user: UserEntity = UserEntity(),
    var videoFiles: ArrayList<VideoFileEntity> = arrayListOf(),
    var videoPictures: ArrayList<VideoPictureEntity> = arrayListOf()
)
