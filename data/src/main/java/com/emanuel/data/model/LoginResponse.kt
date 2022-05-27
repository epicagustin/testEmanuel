package com.emanuel.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token") val access_token: String,
    @SerializedName("expires_in") val expires_in: Int,
    @SerializedName("products") val products: List<ProductResponse>
)