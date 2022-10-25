package com.bindu.electronicsale.api

import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.model.TelevisionObject

interface TelevisionsApi
{
    suspend fun getTelevisions(): TelevisionObject
    suspend fun getTelevision(): Television
}