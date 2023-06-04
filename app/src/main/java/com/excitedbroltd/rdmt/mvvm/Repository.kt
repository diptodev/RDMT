package com.excitedbroltd.rdmt.mvvm

import com.excitedbroltd.rdmt.roomdatabase.Dao
import com.excitedbroltd.rdmt.roomdatabase.User

class Repository(private val userDao: Dao) {
    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    fun getAllUser() = userDao.getAllUser()
}