package com.example.networking.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RefreshToken(
    @SerializedName("access_token")
    val accessToken: String,
    val message: String
)