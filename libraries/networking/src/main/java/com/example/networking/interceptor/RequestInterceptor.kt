package com.example.networking.interceptor

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(private val sharedPreferences: SharedPreferences) :
    Interceptor {
    companion object {
        private var defaultHeaders: Map<String, String>? = null

        fun setDefaultHeaders(headers: Map<String, String>?) {
            defaultHeaders = headers
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        return if (defaultHeaders == null) {
            requestWithToken(chain, chain.request())
        } else {
            val requestBuilder = request.newBuilder()
            for (key in defaultHeaders!!.keys) {
                requestBuilder.addHeader(key, defaultHeaders?.get(key).toString())
            }
            chain.proceed(requestBuilder.build())
        }
    }

    private fun requestWithToken(
        chain: Interceptor.Chain,
        request: Request,
    ): Response {
        return chain.proceed(request)
    }
}