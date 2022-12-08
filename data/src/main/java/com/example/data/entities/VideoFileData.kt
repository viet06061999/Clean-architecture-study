package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.entities.enum_type.QUALITY
import com.google.gson.annotations.SerializedName

@Entity
data class VideoFileData(
    @SerializedName("id")
    @PrimaryKey
    val videoFileId: Int = -1,
    @SerializedName("quality")
    @ColumnInfo(name = "quality")
    val quality: QUALITY = QUALITY.SD,
    @SerializedName("file_type")
    @ColumnInfo(name = "file_type")
    val fileType: String = "",
    @SerializedName("width")
    @ColumnInfo(name = "width")
    var width: Int = -1,
    @SerializedName("height")
    @ColumnInfo(name = "height")
    var height: Int = -1,
    @SerializedName("link")
    @ColumnInfo(name = "link")
    var link: String = "",
    var videoId: Int = -1,
)
