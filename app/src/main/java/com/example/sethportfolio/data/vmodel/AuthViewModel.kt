package com.example.sethportfolio.data.vmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.User
import com.example.sethportfolio.data.repo.AuthRepo

class AuthViewModel:ViewModel() {

    val repo = AuthRepo()

    val registerUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

    val loginUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

    fun buttonRegisterClicked(view: View) {

        //App.instance.log(registerUser.value.toString())
        //Call Repo register function
        repo.registerUser(registerUser)
    }

    fun buttonLoginClicked(view:View) {
        App.instance.log(loginUser.value.toString())
    }
}