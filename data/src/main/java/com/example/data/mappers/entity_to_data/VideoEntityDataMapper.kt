package com.example.data.mappers.entity_to_data

import com.example.data.entities.VideoData
import com.example.domain.common.Mapper
import com.example.domain.entities.UserEntity
import com.example.domain.entities.VideoEntity

class VideoEntityDataMapper : Mapper<VideoEntity, VideoData>() {

    override fun mapFrom(from: VideoEntity): VideoData {
        return VideoData()
    }
}
