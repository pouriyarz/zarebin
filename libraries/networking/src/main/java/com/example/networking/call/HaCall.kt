package com.example.networking.call

import com.example.networking.handler.ApiHandler
import com.example.networking.handler.handleError
import okhttp3.Request
import okio.Timeout
import com.example.networking.response.HaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class HaCall<T : Any>(
    private val call: Call<T>,
    private val responseType: Type,

    ) : Call<HaResponse<T>> {
    override fun clone(): Call<HaResponse<T>> = HaCall(call.clone(), responseType)

    override fun execute(): Response<HaResponse<T>> {
        throw UnsupportedOperationException("Ha Network dose not support synchronous execution")
    }

    override fun enqueue(callback: Callback<HaResponse<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val res = ApiHandler.handle(response, responseType)
                callback.onResponse(this@HaCall, Response.success(res))
            }

            override fun onFailure(call: Call<T>, throwable: Throwable) {
                val res = throwable.handleError<T>()
                callback.onResponse(this@HaCall, Response.success(res))
            }
        })
    }

    override fun isExecuted(): Boolean = synchronized(this) {
        call.isExecuted
    }

    override fun cancel() = synchronized(this) {
        call.cancel()
    }

    override fun isCanceled(): Boolean = synchronized(this) {
        call.isCanceled
    }

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()
}