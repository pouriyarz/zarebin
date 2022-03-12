package com.example.networking.factory

import com.example.networking.adapter.HaCallAdapter
import com.example.networking.aspect.AuthenticatedApi
import com.example.networking.response.HaResponse
import com.example.networking.utils.Holder
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class HaCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        check(returnType is ParameterizedType) {
            "$returnType must be parameterized. Raw not support"
        }

        val mainType = getParameterUpperBound(0, returnType)

        if (getRawType(mainType) != HaResponse::class.java) {
            return null
        }

        check(mainType is ParameterizedType) {
            "$returnType must be parameterized. Raw not support"
        }

        val responseType = mainType.getResponseType()
        isAuthenticatedApi(annotations)
        return HaCallAdapter<Any>(responseType)
    }

    private fun ParameterizedType.getResponseType(): Type {
        return getParameterUpperBound(0, this)
    }

    private fun isAuthenticatedApi(annotations: Array<Annotation>) {
        val authenticatedApiApi = annotations.find { it is AuthenticatedApi }
        authenticatedApiApi?.let { Holder.setAuthenticated(true) } ?: Holder.setAuthenticated(false)
    }

    companion object {
        fun create(): HaCallAdapterFactory {
            return HaCallAdapterFactory()
        }
    }
}