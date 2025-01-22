package com.example.characters.data.model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count") val limit: Int,
    @SerializedName("pages") val page: Int,
)