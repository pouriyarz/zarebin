package com.example.networking.utils

object Constant {
    const val TIME_OUT = 20000L
    const val AUTHORIZATION = "Authorization"
    const val MAP_TOKEN = "x-api-key"
    var BASE_URL = "https://arsh.hamahang.org/api/"

    fun generateBaseUrl(url: String) {
        BASE_URL = url
    }
}