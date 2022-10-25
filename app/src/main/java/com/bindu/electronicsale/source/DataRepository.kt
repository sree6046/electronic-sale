package com.bindu.electronicsale.source

import com.bindu.electronicsale.api.TelevisionsApi
import com.bindu.electronicsale.model.Television

class DataRepository(private val moviesApi: TelevisionsApi) {

    suspend fun getTelevisions(): List<Television> {
        return moviesApi.getTelevisions().televisions
    }

    suspend fun getTelevision(): Television {
        return moviesApi.getTelevision()
    }
}