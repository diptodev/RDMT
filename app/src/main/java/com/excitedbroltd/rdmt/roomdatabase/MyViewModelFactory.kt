package com.excitedbroltd.rdmt.roomdatabase

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.excitedbroltd.rdmt.mvvm.MyViewModel

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(context) as T
        }
        throw IllegalArgumentException("Some exception occurred")

    }
}