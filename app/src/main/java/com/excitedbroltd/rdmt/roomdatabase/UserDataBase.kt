package com.excitedbroltd.rdmt.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getUserDao(): Dao
}