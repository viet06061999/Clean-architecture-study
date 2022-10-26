package com.example.presentation.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoFileUIEntity(
    val videoFileId: Int = -1,
    val quality: String = "",
    val fileType: String = "",
    var link: String = ""
) : Parcelable
