package com.excitedbroltd.rdmt.di.application

import android.app.Application
import com.excitedbroltd.rdmt.di.DaggerDatabaseComponent
import com.excitedbroltd.rdmt.di.component.DatabaseComponent

class DatabaseApplication : Application() {
     lateinit var databaseComponent: DatabaseComponent
    override fun onCreate() {
        super.onCreate()
        databaseComponent = DaggerDatabaseComponent.factory().create(this)
    }
}