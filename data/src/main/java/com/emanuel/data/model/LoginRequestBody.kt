package com.emanuel.data.model

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("dni") var dni: String,
    @SerializedName("password") var password: String
)