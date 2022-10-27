package com.bindu.electronicsale.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TelevisionDao {

    @Query("SELECT * FROM TelevisionData")
    fun getAll(): List<TelevisionData>

    @Insert
    fun insertAll(vararg television: TelevisionData)

    @Delete
    fun delete(television: TelevisionData)

    @Query("DELETE FROM TelevisionData WHERE itemid = :itemId")
    fun deleteByTelevisionId(itemId: Int)

    @Query("DELETE FROM TelevisionData")
    fun deleteAll()
}