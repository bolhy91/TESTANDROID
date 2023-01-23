package com.bolhy91.connecttest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PersonEntity::class],
    version = 1
)
abstract class ConnectDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}