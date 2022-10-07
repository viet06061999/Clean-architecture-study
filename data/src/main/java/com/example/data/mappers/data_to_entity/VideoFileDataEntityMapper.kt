package com.example.data.mappers.data_to_entity

import com.example.data.entities.VideoFileData
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoFileEntity

class VideoFileDataEntityMapper : Mapper<VideoFileData, VideoFileEntity>() {

    override fun mapFrom(from: VideoFileData): VideoFileEntity {
       return VideoFileEntity(from.videoFileId, from.quality.name, from.fileType, from.width, from.height, from.link)
    }
}
