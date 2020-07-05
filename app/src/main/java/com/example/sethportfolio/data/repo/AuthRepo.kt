package com.example.sethportfolio.data.repo


import androidx.lifecycle.MutableLiveData
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.SessionManager
import com.example.sethportfolio.data.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class AuthRepo() {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var auth:FirebaseAuth

    @Inject
    lateinit var sm:SessionManager


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

    suspend fun loginUser(user:MutableLiveData<User>):Boolean{
        try {
            sm.addUser(user.value!!)
            auth.signInWithEmailAndPassword(user.value?.email!!, user.value?.password!!).await()
            return true
        } catch(e:Exception) {
            return false
        }
    }

}