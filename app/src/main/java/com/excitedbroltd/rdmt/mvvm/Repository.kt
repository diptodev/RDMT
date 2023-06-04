package com.excitedbroltd.rdmt.mvvm

import com.excitedbroltd.rdmt.roomdatabase.User
import com.excitedbroltd.rdmt.roomdatabase.UserDataBase
import javax.inject.Inject

class Repository @Inject constructor(val userDataBase: UserDataBase) {
    suspend fun addUser(user: User) {
        userDataBase.getUserDao().addUser(user)
    }

    fun getAllUser() = userDataBase.getUserDao().getAllUser()
    suspend fun updateUser(user: User) {
        userDataBase.getUserDao().updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDataBase.getUserDao().deleteUser(user)
    }
}