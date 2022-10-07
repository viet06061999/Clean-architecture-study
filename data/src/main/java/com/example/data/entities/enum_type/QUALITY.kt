package com.example.data.entities.enum_type

import com.google.gson.annotations.SerializedName

enum class QUALITY {
    @SerializedName("sd")
    SD,

    @SerializedName("hd")
    HD;

    override fun toString(): String {
        return super.toString().lowercase()
    }
}