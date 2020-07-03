package com.example.sethportfolio.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.sethportfolio.R
import com.example.sethportfolio.data.app.*
import com.example.sethportfolio.data.model.User
import com.example.sethportfolio.data.vmodel.AuthViewModel
import com.example.sethportfolio.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityRegisterBinding
    val viewModel:AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        mBinding.authViewModel = viewModel
        mBinding.lifecycleOwner = this

//
//        viewModel.repo.response.onlyNew(this).observe(this, Observer {
//            when(it) {
//                true -> {
//                    toast("Register Successful")
//                    startActivity(Intent(applicationContext,LoginActivity::class.java))
//                }
//                false -> {
//                    toast("Register failed, User already registered")
//                    viewModel.registerUser.value = User()
//                }
//            }
//        })

        viewModel.checkRegister.onlyNew(this).observe(this, Observer{
            when(it) {
                true -> {
                    toast("Register Successful")
                    startActivity(Intent(applicationContext,LoginActivity::class.java))
                }
                false -> {
                    toast("Register failed, User already registered")
                    viewModel.registerUser.value = User()
                }
            }
        })

    }
}