package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class VideoPictureData(
    @SerializedName("id")
    var id: Int = -1,
    @SerializedName("picture")
    var picture: String = "",
    @SerializedName("nr")
    var nr: Int = -1
)
