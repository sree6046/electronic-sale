package com.bindu.electronicsale.api

import com.bindu.electronicsale.model.TelevisionObject

interface TelevisionsOfflineApi {
    suspend fun getTelevisions(): TelevisionObject
}