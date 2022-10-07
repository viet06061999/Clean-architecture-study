package com.example.domain.entities

import com.example.domain.entities.enum_type.QUALITY

data class VideoFileEntity(
    val videoFileId: Int = -1,
    val quality: QUALITY = QUALITY.SD,
    val fileType: String = "",
    var width: Int = -1,
    var height: Int = -1,
    var fps: Double = -1.0,
    var link: String = ""
)
