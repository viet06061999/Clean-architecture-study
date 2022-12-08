package com.example.data.mappers.entity_to_data

import com.example.data.entities.VideoPictureData
import com.example.domain.common.Mapper
import com.example.domain.entities.VideoPictureEntity

class VideoPictureEntityDataMapper : Mapper<VideoPictureEntity, VideoPictureData>() {

    override fun mapFrom(from: VideoPictureEntity): VideoPictureData {
        return VideoPictureData(from.id, from.picture, from.nr)
    }
}
