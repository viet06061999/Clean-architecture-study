package com.example.domain.entities.enum_type

enum class QUALITY {
    SD, HD;

    override fun toString(): String {
        return super.toString().lowercase()
    }
}