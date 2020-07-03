package com.example.sethportfolio.data.vmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.User

class AuthViewModel:ViewModel() {

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

        App.instance.log(registerUser.value.toString())
    }

    fun buttonLoginClicked(view:View) {
        App.instance.log(loginUser.value.toString())
    }
}