package com.excitedbroltd.rdmt.mvvm

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.excitedbroltd.rdmt.roomdatabase.User
import com.excitedbroltd.rdmt.roomdatabase.UserDataBase
import kotlinx.coroutines.launch

class MyViewModel(private val context: Context) : ViewModel() {
    private val TAG = "MyViewModel"
    val instance: UserDataBase = UserDataBase.getInstance(context)
    val repository = Repository(instance.getUserDao())
    fun addUser(user: User) {
        viewModelScope.launch {


            repository.addUser(user)
            Toast.makeText(context, "User added", Toast.LENGTH_SHORT).show()
        }

    }

    fun getUserdata(): LiveData<List<User>> {
        return repository.getAllUser()
    }

    fun deletePerson(user: User) {
        viewModelScope.launch {
            repository.deleteUser(user)
        }
    }

    fun updatePerson(user: User) {
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }
}