package com.bindu.electronicsale.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TelevisionData::class], version = 1)
abstract class TelevisionDatabase : RoomDatabase() {

    abstract fun televsionDao(): TelevisionDao

}