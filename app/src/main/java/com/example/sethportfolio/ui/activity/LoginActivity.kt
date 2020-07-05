package com.example.sethportfolio.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.sethportfolio.R
import com.example.sethportfolio.data.app.toast
import com.example.sethportfolio.data.model.User
import com.example.sethportfolio.data.vmodel.AuthViewModel
import com.example.sethportfolio.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var mBinding:ActivityLoginBinding
    val viewModel:AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.authViewModel = viewModel
        mBinding.lifecycleOwner = this

        text_view_register.setOnClickListener(this)

        viewModel.loginResponse.observe(this, Observer {
            when(it) {
                true -> {
                    toast("Login Success")
                    startActivity(Intent(this, MainActivity::class.java))
                }
                false ->{
                    toast("Login Failed")
                    viewModel.loginUser.value = User()
                }
            }
        })
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.text_view_register -> { startActivity(Intent(this,RegisterActivity::class.java))}
        }
    }
}