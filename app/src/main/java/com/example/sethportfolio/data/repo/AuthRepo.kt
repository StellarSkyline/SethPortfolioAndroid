package com.example.sethportfolio.data.repo


import androidx.lifecycle.MutableLiveData
import com.example.sethportfolio.data.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
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

    suspend fun loginUser(user:MutableLiveData<User>):Boolean{
        try {
            auth.signInWithEmailAndPassword(user.value?.email!!, user.value?.password!!).await()
            return true
        } catch(e:Exception) {
            return false
        }
    }

}