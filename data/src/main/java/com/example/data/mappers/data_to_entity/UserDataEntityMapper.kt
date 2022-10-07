package com.example.data.mappers.data_to_entity

import com.example.data.entities.UserData
import com.example.domain.common.Mapper
import com.example.domain.entities.UserEntity

class UserDataEntityMapper : Mapper<UserData, UserEntity>() {

    override fun mapFrom(from: UserData): UserEntity {
        return UserEntity(from.userId, from.name, from.url)
    }
}
