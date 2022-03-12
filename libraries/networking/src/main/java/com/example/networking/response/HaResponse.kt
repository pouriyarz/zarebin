package com.example.networking.response

import com.google.gson.annotations.SerializedName

sealed class HaResponse<T : Any> {
        data class Success<T : Any>(
            @SerializedName("body")
            val body: T?,
            @SerializedName("message")
            val message: String?,
            @SerializedName("status")
            val status: Status,
            @SerializedName("code")
            val code: Int
        ) : HaResponse<T>()

        data class Failed<T : Any>(
            @SerializedName("body")
            val body: T?,
            @SerializedName("message")
            val message: String?,
            @SerializedName("status")
            val status: Status,
            @SerializedName("code")
            val code: Int
        ) : HaResponse<T>()
    }

    enum class Status {
        SUCCESS, FAILED, NETWORK_FAILED
}