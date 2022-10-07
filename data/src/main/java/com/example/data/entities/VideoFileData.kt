package com.example.data.entities

import com.example.data.entities.enum_type.QUALITY
import com.google.gson.annotations.SerializedName

data class VideoFileData(
    @SerializedName("")
    val videoFileId: Int = -1,
    @SerializedName("quality")
    val quality: QUALITY = QUALITY.SD,
    @SerializedName("file_type")
    val fileType: String = "",
    @SerializedName("width")
    var width: Int = -1,
    @SerializedName("height")
    var height: Int = -1,
    @SerializedName("link")
    var link: String = ""
)
