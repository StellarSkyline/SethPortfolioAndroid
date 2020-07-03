package com.example.sethportfolio.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.User
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class AuthRepo() {
    lateinit var auth:FirebaseAuth
    //val auth by lazy {FirebaseAuth.getInstance()}
    init {
        //FirebaseApp.initializeApp(App.instance)
        auth = FirebaseAuth.getInstance()
    }


    fun registerUser(user: MutableLiveData<User>):Boolean{
        var checkSuccess = false

        auth.createUserWithEmailAndPassword(user.value?.email!!, user.value?.password!!)
            .addOnCompleteListener{
                if(it.isSuccessful) {
                    App.instance.log("Register Success")
                    checkSuccess = true

                } else {
                    App.instance.log("Register Failed")
                    checkSuccess = false
                }
            }

        return checkSuccess
    }
}