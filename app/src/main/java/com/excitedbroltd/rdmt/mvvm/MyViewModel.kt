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
    fun addUser(id: Int, name: String, age: String) {
        viewModelScope.launch {
            if (name.isNotEmpty() && age.isNotEmpty()) {
                val user = User(0, name, Integer.parseInt(age))
                repository.addUser(user)
                Toast.makeText(context, "User added", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun getUserdata(): LiveData<List<User>> {
        return repository.getAllUser()
    }
}