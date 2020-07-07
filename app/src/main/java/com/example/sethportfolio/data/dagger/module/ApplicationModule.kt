package com.example.sethportfolio.data.dagger.module

import com.example.sethportfolio.data.app.Config
import com.example.sethportfolio.data.app.SessionManager
import com.example.sethportfolio.data.network.ApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun sharedUser():SessionManager {
        return SessionManager()
    }

    @Singleton
    @Provides
    fun fbAuth():FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Singleton
    @Provides
    fun apiClient():ApiClient {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Config.BASE_URL)
            .build()
            .create(ApiClient::class.java)
    }

    @Singleton
    @Provides
    fun fbDatabase():DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(Config.COLLECTION_NAME)
    }



}