package com.example.data.mappers.entity_to_data

import com.example.data.entities.VideoData
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoEntity

class VideoEntityDataMapper : Mapper<VideoEntity, VideoData>() {

    override fun mapFrom(from: VideoEntity): VideoData {
        return VideoData(id = from.id,
            width = from.width,
            height = from.height,
            url = from.url,
            image = from.image,
            duration = from.duration,
            user = UserEntityDataMapper().mapFrom(from.user),
            videoFiles = from.videoFiles.map { VideoFileEntityDataMapper().mapFrom(it) },
            videoPictures = from.videoPictures.map { VideoPictureEntityDataMapper().mapFrom(it) })
    }
}
