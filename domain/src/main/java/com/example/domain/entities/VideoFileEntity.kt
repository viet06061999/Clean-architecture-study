package com.example.domain.entities

data class VideoFileEntity(
    val videoFileId: Int = -1,
    val quality: String = "",
    val fileType: String = "",
    var width: Int = -1,
    var height: Int = -1,
    var link: String = ""
)
