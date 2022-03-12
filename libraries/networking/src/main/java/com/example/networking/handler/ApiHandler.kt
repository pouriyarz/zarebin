package com.example.networking.handler

import com.google.gson.Gson
import okhttp3.ResponseBody
import com.example.networking.response.HaResponse
import com.example.networking.response.Status
import com.example.networking.response.error.HaErrorResponse
import com.example.networking.utils.Message
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

@Suppress("UNCHECKED_CAST")
object ApiHandler {

    fun <T : Any> handle(response: Response<T>, responseType: Type): HaResponse<T> {
        val body = response.body()
        val errorBody = response.errorBody()

        if (response.isSuccessful) {
            return if (body != null) {
                HaResponse.Success(body, null, Status.SUCCESS, response.code())
            } else {
                if (responseType == Unit::class.java) {
                    HaResponse.Success(Unit, null, Status.SUCCESS, response.code()) as HaResponse<T>
                } else if (response.code() == 204) {
                    HaResponse.Failed(
                        null,
                        readStringError(),
                        Status.FAILED,
                        response.code()
                    )
                } else {
                    HaResponse.Failed(
                        null,
                        readError(errorBody, Gson()),
                        Status.FAILED,
                        response.code()
                    )
                }
            }
        } else if (response.code() == 400) {
            return HaResponse.Failed(
                null,
                readError(errorBody, Gson()),
                Status.FAILED,
                response.code()
            )
        } else if (response.code() == 500) {
            return HaResponse.Failed(
                null,
                readError(null, Gson()),
                Status.FAILED,
                response.code()
            )
        } else {
            return HaResponse.Failed(
                null,
                readError(errorBody, Gson()),
                Status.FAILED,
                response.code()
            )
        }
    }

//    private fun <T : Any> parseBody(body: T): T? {
//        return try {
//            val parameter = body::class.members.first { it.name == BODY } as KProperty1<Any, *>
//            parameter.get(body) as T?
//        } catch (e: NoSuchElementException) {
//            body
//        }
//    }
}

fun <T : Any> Throwable.handleError(): HaResponse<T> {
    return when (this) {
        is IOException -> {
            HaResponse.Failed(null, Message.IO_ERROR, Status.NETWORK_FAILED, 100)
        }
        is HttpException -> {
            HaResponse.Failed(null, readError(this), Status.FAILED, 101)
        }
        else -> HaResponse.Failed(null, Message.UNKNOWN_ERROR, Status.FAILED, 999)
    }
}

private fun readError(errorBody: ResponseBody?, gson: Gson): String {
    return try {
        errorBody?.let {
            val json = it.string().replaceFirst("\"", "").replaceFirst("\"", "")
            val error = gson.fromJson(json, HaErrorResponse::class.java)
            return@let error.message[0]
        } ?: Message.UNKNOWN_ERROR
    } catch (exception: Exception) {
        exception.stackTrace
        Message.UNKNOWN_ERROR
    }
}

private fun readStringError(): String {
    return try {
        Message.STATUS_CODE_204
    } catch (exception: Exception) {
        Message.STATUS_CODE_204
    }
}

fun readError(httpException: HttpException): String {
    return try {
        httpException.response()?.let { response ->
            response.errorBody()?.let {
                val error =
                    Gson().fromJson(it.string().replaceFirst("\"", ""), HaErrorResponse::class.java)
                error.message[0]
            } ?: Message.UNKNOWN_ERROR
        } ?: Message.UNKNOWN_ERROR
    } catch (exception: Exception) {
        Message.UNKNOWN_ERROR
    }
}