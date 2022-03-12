package com.example.networking.response.error

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HaErrorResponse(
    @SerializedName("detail")
    val message: ArrayList<String>
)