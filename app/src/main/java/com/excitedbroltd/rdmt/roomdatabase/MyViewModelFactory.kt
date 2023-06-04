package com.excitedbroltd.rdmt.roomdatabase

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.excitedbroltd.rdmt.mvvm.MyViewModel
import com.excitedbroltd.rdmt.mvvm.Repository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory @Inject constructor(
    private val context: Context,
    val repository: Repository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(context, repository) as T
        }
        throw IllegalArgumentException("Some exception occurred")

    }
}