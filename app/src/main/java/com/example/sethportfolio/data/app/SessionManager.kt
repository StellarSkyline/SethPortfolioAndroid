package com.example.sethportfolio.data.app

import android.content.Context
import com.example.sethportfolio.data.model.User

class SessionManager {
    val USER_NAME = "userName"
    val USER_EMAIL = "userEmail"
    val USER_MOBILE = "userMobile"

    val editor = sharePreference.edit()

    fun addUser(name:String, email:String,mobile:String) {
        editor.putString(USER_NAME,name)
        editor.putString(USER_EMAIL, email)
        editor.putString(USER_MOBILE,mobile)
        editor.commit()
    }

    fun getUser():User {
        return User(name = sharePreference.getString(USER_NAME,null)!!,
            email = sharePreference.getString(USER_EMAIL,null)!!,
            mobile = sharePreference.getString(USER_MOBILE,null)!!)
    }



    companion object{
        val sharePreference by lazy {
            App.instance.getSharedPreferences(Config.FILE_NAME, Context.MODE_PRIVATE)
        }
    }
}