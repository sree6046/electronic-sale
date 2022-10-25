package com.bindu.electronicsale.repository

import com.bindu.electronicsale.api.MobileOfflineApi
import com.bindu.electronicsale.api.TelevisionsOfflineApi
import com.bindu.electronicsale.model.Mobile
import com.bindu.electronicsale.model.Television

class DataRepository(
    private val televisionApi: TelevisionsOfflineApi,
    private val mobileApi: MobileOfflineApi
) {

    suspend fun getTelevisions(): List<Television> {
        return televisionApi.getTelevisions().televisions
    }

    suspend fun getMobiles(): List<Mobile> {
        return mobileApi.getMobiles().mobiles
    }
}