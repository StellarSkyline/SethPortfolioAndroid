package com.example.sethportfolio.data.dagger.component

import com.example.sethportfolio.data.dagger.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    //Dependency Graph where dagger will work
    //fun inject(function or class)
}