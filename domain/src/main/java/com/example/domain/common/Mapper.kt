package com.example.domain.common

import com.example.domain.entities.Optional

abstract class Mapper<in E, T> {

    abstract fun mapFrom(from: E): T

    fun mapOptional(from: Optional<E>): Optional<T> {
        from.value?.let {
            return Optional(mapFrom(it))
        } ?: return Optional.empty()
    }
}