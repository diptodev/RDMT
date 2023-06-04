package com.excitedbroltd.rdmt.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase() : RoomDatabase() {
    abstract fun getUserDao(): Dao

    companion object {
        @Volatile
        var INSTANCE: UserDataBase? = null
        fun getInstance(context: Context): UserDataBase {
            var tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val mtempInstance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_database"
                ).build()
                INSTANCE = mtempInstance
                return mtempInstance
            }
        }
    }


}