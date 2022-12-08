package com.example.data.mappers.data_to_entity

import com.example.data.entities.VideoPictureData
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoPictureEntity

class VideoPictureDataEntityMapper : Mapper<VideoPictureData, VideoPictureEntity>() {

    override fun mapFrom(from: VideoPictureData): VideoPictureEntity {
        return VideoPictureEntity(from.videoPictureId, from.picture, from.nr)
    }
}
