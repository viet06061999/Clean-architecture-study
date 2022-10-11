package com.example.domain.common

import com.example.domain.entities.Optional
import io.reactivex.rxjava3.core.Observable

abstract class Mapper<in E, T> {

    abstract fun mapFrom(from: E): T

    fun mapOptional(from: Optional<E>): Optional<T> {
        from.value?.let {
            return Optional(mapFrom(it))
        } ?: return Optional.empty()
    }

    fun observable(from: List<E>): Observable<List<T>> {
        return Observable.fromCallable {
            from.map {
                mapFrom(it)
            }
        }
    }
}