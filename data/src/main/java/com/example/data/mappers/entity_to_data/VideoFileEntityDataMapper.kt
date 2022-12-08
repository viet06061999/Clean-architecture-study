package com.example.data.mappers.entity_to_data

import com.example.data.entities.VideoFileData
import com.example.data.entities.enum_type.QUALITY
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoFileEntity

class VideoFileEntityDataMapper : Mapper<VideoFileEntity, VideoFileData>() {

    override fun mapFrom(from: VideoFileEntity): VideoFileData {
        return VideoFileData(
            from.videoFileId,
            QUALITY.valueOf(from.quality),
            from.fileType,
            from.width,
            from.height,
            from.link
        )
    }
}
