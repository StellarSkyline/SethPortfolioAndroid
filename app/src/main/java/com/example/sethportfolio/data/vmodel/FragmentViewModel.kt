package com.example.sethportfolio.data.vmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.app.log
import com.example.sethportfolio.data.model.Graphics
import com.example.sethportfolio.data.repo.FragmentRepo
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentViewModel:ViewModel() {

    //Initalize repo
    val repo by lazy { FragmentRepo() }

    val graphicsResponse by lazy{ MutableLiveData<Boolean>()}


    //Home Fragment items============================

    fun introText():String {
        return repo.introString
    }


    //===============================================

    //Graphics Fragment =============================

    fun getGraphicsList(){
        viewModelScope.launch {
            var x = repo.getGraphics()
            withContext(Main) {
                graphicsResponse.value = x
            }
        }
    }

    //===============================================


}