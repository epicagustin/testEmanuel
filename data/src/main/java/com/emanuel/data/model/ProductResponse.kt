package com.emanuel.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("detail") val detail: String,
    @SerializedName("name") val name: String
)