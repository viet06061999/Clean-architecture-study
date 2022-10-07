package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class UserData(

    @SerializedName("id")
    val userId: Int = -1,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = ""
)
