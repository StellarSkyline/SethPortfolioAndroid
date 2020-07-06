package com.example.sethportfolio.data.vmodel

import androidx.lifecycle.ViewModel
import com.example.sethportfolio.data.model.Graphics
import com.example.sethportfolio.data.repo.FragmentRepo

class FragmentViewModel:ViewModel() {

    //Initalize repo
    val repo by lazy { FragmentRepo() }


    //Home Fragment items============================

    fun introText():String {
        return repo.introString
    }


    //===============================================

    //Graphics Fragment =============================

    fun getGraphicsList():ArrayList<Graphics> {
        return repo.getGraphics()
    }

    //===============================================


}