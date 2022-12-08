package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class VideoPictureData(
    @SerializedName("id")
    @PrimaryKey
    var videoPictureId: Int = -1,
    @SerializedName("picture")
    @ColumnInfo(name = "picture")
    var picture: String = "",
    @SerializedName("nr")
    @ColumnInfo(name = "nr")
    var nr: Int = -1,
    var videoId: Int = -1,
)
