package com.excitedbroltd.rdmt.di

import android.content.Context
import androidx.room.Room
import com.excitedbroltd.rdmt.roomdatabase.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserDataBaseModule {
    @Provides
    @Singleton
    fun getDatabaseObj(context: Context): UserDataBase {
        return Room.databaseBuilder(context, UserDataBase::class.java, "user_database").build()
    }

}