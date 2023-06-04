package com.excitedbroltd.rdmt.di

import android.app.Application

class DatabaseApplication : Application() {
     lateinit var databaseComponent: DatabaseComponent
    override fun onCreate() {
        super.onCreate()
        databaseComponent = DaggerDatabaseComponent.factory().create(this)
    }
}