package com.example.presentation.mappers

import com.example.domain.common.Mapper
import com.example.domain.entities.VideoEntity
import com.example.presentation.entities.VideoFileUIEntity
import com.example.presentation.entities.VideoPictureUIEntity
import com.example.presentation.entities.VideoUIEntity

class VideoEntityToUIMapper:Mapper<VideoEntity, VideoUIEntity>() {

    override fun mapFrom(from: VideoEntity): VideoUIEntity {
        return VideoUIEntity(
            id = from.id,
            width = from.width,
            height = from.height,
            url = from.url,
            image = from.image,
            duration = from.duration,
            user = from.user.name,
            videoFiles = from.videoFiles.map {
            VideoFileUIEntity(it.videoFileId,it.quality,it.fileType,it.link)
            },
            videoPictures = from.videoPictures.map {
                VideoPictureUIEntity(it.id, it.picture)
            }
        )
    }
}