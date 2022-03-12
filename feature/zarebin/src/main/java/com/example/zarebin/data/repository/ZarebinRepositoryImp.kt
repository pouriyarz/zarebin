package com.example.zarebin.data.repository

import com.example.networking.response.HaResponse
import com.example.zarebin.data.model.ZarebinModel
import com.example.zarebin.data.service.ZarebinService
import javax.inject.Inject

class ZarebinRepositoryImp @Inject constructor(
    private val zarebinService: ZarebinService,
) : ZarebinRepository {
    override suspend fun getList(): HaResponse<ArrayList<ZarebinModel>> {
        return zarebinService.getList()
    }
}