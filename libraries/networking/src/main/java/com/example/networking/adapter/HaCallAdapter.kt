package com.example.networking.adapter

import com.example.networking.call.HaCall
import com.example.networking.response.HaResponse
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class HaCallAdapter<T : Any>(private val responseType: Type) : CallAdapter<T, Call<HaResponse<T>>> {
    override fun responseType(): Type = responseType

    override fun adapt(call: Call<T>): Call<HaResponse<T>> {
        return HaCall(call, responseType)
    }
}