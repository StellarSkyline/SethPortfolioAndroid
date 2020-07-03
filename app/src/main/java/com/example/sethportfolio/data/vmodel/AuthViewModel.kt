package com.example.sethportfolio.data.vmodel

import android.view.View
import androidx.lifecycle.*
import com.example.sethportfolio.data.app.App
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
    //Repo Instansation
    val repo = AuthRepo()
    //=====================================

    //Register Items
    //======================================
    val registerUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

    val checkRegister by lazy {
        MutableLiveData<Boolean>()
    }

    //Login Items
    //=======================================
    val loginUser by lazy {
        val x = MutableLiveData<User>()
        x.value = User()
        x
    }

    //Functions
    //==================================

    fun buttonRegisterClicked(view: View) {
        //run repo registerUser and run it in corotuine
        viewModelScope.launch{
            var x = repo.registerUser(registerUser)
            withContext(Main) {
                checkRegister.value = x
            }
        }
    }




    fun buttonLoginClicked(view:View) {
        App.instance.log(loginUser.value.toString())
    }
}