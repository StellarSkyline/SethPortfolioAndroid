package com.example.sethportfolio.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.sethportfolio.R
import com.example.sethportfolio.data.vmodel.AuthViewModel
import com.example.sethportfolio.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityRegisterBinding
    val viewModel:AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_register)
        mBinding.authViewModel = viewModel
        mBinding.lifecycleOwner = this

    }
}