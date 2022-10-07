package com.example.domain.entities

class Optional<out T>(val value: T? = null) {

    companion object {

        fun <T> of(value: T?) = Optional(value)

        fun <T> empty() = Optional<T>()
    }

    fun hasValue(): Boolean {
        return value != null
    }
}