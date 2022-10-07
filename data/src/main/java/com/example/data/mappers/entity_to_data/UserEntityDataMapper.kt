package com.example.data.mappers.entity_to_data

import com.example.data.entities.UserData
import com.example.data.entities.VideoFileData
import com.example.domain.common.Mapper
import com.example.domain.entities.UserEntity
import com.example.domain.entities.VideoFileEntity

class UserEntityDataMapper : Mapper<UserEntity, UserData>() {

    override fun mapFrom(from: UserEntity): UserData {
        return UserData()
    }
}
