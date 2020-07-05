package com.example.sethportfolio.data.vmodel

import android.view.View
import androidx.lifecycle.*
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.SessionManager
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.app.onlyNew
import com.example.sethportfolio.data.model.User
import com.example.sethportfolio.data.repo.AuthRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel:ViewModel() {
    //Repo Instance
    val repo = AuthRepo()
    val sm = SessionManager()
    //=====================================

    //Register Items
    //======================================
    val registerUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

    val registerResponse by lazy {MutableLiveData<Boolean>()}

    //Login Items
    //=======================================
    val loginUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

     val loginResponse by lazy{MutableLiveData<Boolean>()}

    //Functions
    //==================================

    fun buttonRegisterClicked(view: View) {
        //run repo registerUser and run it in corotuine
        viewModelScope.launch{
            var x = repo.registerUser(registerUser)

            //setting data should be on the main thread
            withContext(Main) {
                registerResponse.value = x
            }
        }
    }

    fun buttonLoginClicked(view:View) {
        sm.setLogKey(true)
        viewModelScope.launch {
            var x = repo.loginUser(loginUser)

            withContext(Main) {
                loginResponse.value = x
            }
        }
    }
}