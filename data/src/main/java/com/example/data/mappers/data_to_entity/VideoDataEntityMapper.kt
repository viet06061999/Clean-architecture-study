package com.example.data.mappers.data_to_entity

import com.example.data.entities.VideoData
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoEntity

class VideoDataEntityMapper : Mapper<VideoData, VideoEntity>() {

    override fun mapFrom(from: VideoData): VideoEntity {
        return VideoEntity(
            id = from.id,
            width = from.width,
            height = from.height,
            url = from.url,
            image = from.image,
            duration = from.duration,
            user = UserDataEntityMapper().mapFrom(from.user),
            videoFiles = from.videoFiles.map { VideoFileDataEntityMapper().mapFrom(it) },
            videoPictures = from.videoPictures.map { VideoPictureDataEntityMapper().mapFrom(it) }
        )
    }
}
