package com.excitedbroltd.rdmt.di

import android.content.Context
import com.excitedbroltd.rdmt.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserDataBaseModule::class])
interface DatabaseComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DatabaseComponent
    }
}