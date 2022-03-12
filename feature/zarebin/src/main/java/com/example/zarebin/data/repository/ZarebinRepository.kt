package com.example.zarebin.data.repository

import com.example.networking.response.HaResponse
import com.example.zarebin.data.model.ZarebinModel

interface ZarebinRepository {
    suspend fun getList(): HaResponse<ArrayList<ZarebinModel>>
}