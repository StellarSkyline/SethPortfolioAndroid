package com.example.sethportfolio.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.User
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class AuthRepo() {


    val auth = FirebaseAuth.getInstance()

    //Functions
    //=========================================================
    suspend fun registerUser(user: MutableLiveData<User>):Boolean{
        try {
            auth.createUserWithEmailAndPassword(user.value?.email!!, user.value?.password!!).await()
            return true
        } catch(e:Exception) {
            return false
        }
    }

}