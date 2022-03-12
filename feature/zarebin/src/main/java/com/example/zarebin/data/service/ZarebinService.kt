package com.example.zarebin.data.service

import com.example.networking.response.HaResponse
import com.example.zarebin.data.model.ZarebinModel
import retrofit2.http.GET

interface ZarebinService {
    @GET("v1/todo/list")
    suspend fun getList(): HaResponse<ArrayList<ZarebinModel>>
}