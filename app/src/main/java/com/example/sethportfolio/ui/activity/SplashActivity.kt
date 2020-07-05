package com.example.sethportfolio.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sethportfolio.R
import com.example.sethportfolio.data.app.SessionManager

class SplashActivity : AppCompatActivity() {
    val sm = SessionManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
    }

    private fun init() {
        val intent = Intent(this, MainActivity::class.java)
        val intentLogin = Intent(this, LoginActivity::class.java)

        var handler = Handler()

        handler.postDelayed({
            if(sm.logCheck()) {
                startActivity(intent)
            } else {
                startActivity(intentLogin)
            }

        }, 3000)
    }
}