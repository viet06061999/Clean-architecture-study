package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class VideoData(
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("width")
    var width: Int = -1,
    @SerializedName("height")
    var height: Int = -1,
    @SerializedName("url")
    var url: String = "",
    @SerializedName("image")
    var image: String = "",
    @SerializedName("duration")
    var duration: Int = -1,
    @SerializedName("user")
    var user: UserData = UserData(),
    @SerializedName("video_files")
    var videoFiles: List<VideoFileData> = arrayListOf(),
    @SerializedName("video_pictures")
    var videoPictures: List<VideoPictureData> = arrayListOf()
)
