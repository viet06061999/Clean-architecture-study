package com.example.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class UserData(
    @SerializedName("id")
    @PrimaryKey
    val userId: Int = -1,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String = "",
    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String = "",
    var videoId: Int = -1
)
