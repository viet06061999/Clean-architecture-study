package com.example.presentation.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoUIEntity(
    var id: Int = -1,
    var width: Int = -1,
    var height: Int = -1,
    var url: String = "",
    var image: String = "",
    var duration: Int = -1,
    var user: String = "",
    var videoFiles: List<VideoFileUIEntity> = arrayListOf(),
    var videoPictures: List<VideoPictureUIEntity> = arrayListOf()
) : GeneraEntity, Parcelable {

    override fun areItemsTheSame(newItem: GeneraEntity): Boolean =
        newItem is VideoUIEntity && this.id == newItem.id

    override fun areContentsTheSame(newItem: GeneraEntity): Boolean =
        newItem is VideoUIEntity && this == newItem
}
