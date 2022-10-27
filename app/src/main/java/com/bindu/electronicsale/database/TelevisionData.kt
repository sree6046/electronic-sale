package com.bindu.electronicsale.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["itemid"], unique = true)])
data class TelevisionData(
    @ColumnInfo(name = "itemid") val itemid: Int,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "price") val price: Double
) {

    @PrimaryKey(autoGenerate = true)
    var pid: Int? = null
}