package com.example.presentation.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoPictureUIEntity(
    var id: Int = -1,
    var picture: String = ""
) : Parcelable
