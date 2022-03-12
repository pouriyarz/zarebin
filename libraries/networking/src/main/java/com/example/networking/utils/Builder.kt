package com.example.networking.utils

import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.example.networking.interceptor.RequestInterceptor
import java.util.concurrent.TimeUnit

object Builder {
    fun generateClient(
        sharedPreferences: SharedPreferences,
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().callTimeout(Constant.TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(
                Constant.TIME_OUT, TimeUnit.MILLISECONDS
            ).readTimeout(Constant.TIME_OUT, TimeUnit.MILLISECONDS).readTimeout(
                Constant.TIME_OUT, TimeUnit.MILLISECONDS
            ).addInterceptor(loggingInterceptor)
            .addInterceptor(RequestInterceptor(sharedPreferences))
            .followRedirects(false)
            .followSslRedirects(false)
            .build()
    }
}