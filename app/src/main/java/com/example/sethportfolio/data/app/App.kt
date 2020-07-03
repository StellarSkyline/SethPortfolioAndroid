package com.example.sethportfolio.data.app

import android.app.Application
import com.example.sethportfolio.data.dagger.component.ApplicationComponent
import com.example.sethportfolio.data.dagger.component.DaggerApplicationComponent
import com.example.sethportfolio.data.dagger.module.ApplicationModule

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule()).build()
    }

    companion object {
        lateinit var instance:App
        lateinit var component:ApplicationComponent
    }
}