package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Video(
    @SerializedName("id")
    @PrimaryKey
    var id: Int = -1,

    @SerializedName("width")
    @ColumnInfo(name = "width")
    var width: Int = -1,

    @SerializedName("height")
    @ColumnInfo(name = "height")
    var height: Int = -1,

    @SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String = "",

    @SerializedName("image")
    @ColumnInfo(name = "image")
    var image: String = "",

    @SerializedName("duration")
    @ColumnInfo(name = "duration")
    var duration: Int = -1
)