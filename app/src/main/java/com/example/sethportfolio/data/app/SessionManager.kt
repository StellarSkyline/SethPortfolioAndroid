package com.example.sethportfolio.data.app

import android.content.Context
import com.example.sethportfolio.data.model.User

class SessionManager {
    val USER_NAME = "userName"
    val USER_EMAIL = "userEmail"
    val USER_MOBILE = "userMobile"
    val IS_LOGGED_IN = "loggedIn"

    val editor = sharePreference.edit()

    fun addUser(user:User) {
        editor.putString(USER_NAME,user.name)
        editor.putString(USER_EMAIL, user.email)
        editor.putString(USER_MOBILE,user.mobile)
        editor.commit()
    }

    fun getUser():User {
        return User(name = sharePreference.getString(USER_NAME,null)!!,
            email = sharePreference.getString(USER_EMAIL,null)!!,
            mobile = sharePreference.getString(USER_MOBILE,null)!!)
    }

    fun setLogKey(key:Boolean) {
        editor.putBoolean(IS_LOGGED_IN,key)
        editor.commit()
    }

    fun logCheck():Boolean = sharePreference.getBoolean(IS_LOGGED_IN, false)



    companion object{
        val sharePreference by lazy {
            App.instance.getSharedPreferences(Config.FILE_NAME, Context.MODE_PRIVATE)
        }
    }
}