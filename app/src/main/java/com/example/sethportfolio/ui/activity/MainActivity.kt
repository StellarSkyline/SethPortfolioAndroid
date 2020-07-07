package com.example.sethportfolio.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.sethportfolio.R
import com.example.sethportfolio.data.vmodel.FragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    lateinit var navView:BottomNavigationView
    val navController by lazy {findNavController(R.id.nav_host)}
    val viewModel:FragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This will call coroutines and load them all asyncrhonusly in the background
        runFragmentCoroutines()

        navView = bottom_navigation
        navView.itemIconTintList = null
        navView.setOnNavigationItemSelectedListener(this)




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {navController.navigate(R.id.action_global_fragmentHome)}
            R.id.nav_graphics ->{navController.navigate(R.id.action_global_fragmentGraphics)}
            R.id.nav_development ->{navController.navigate(R.id.action_global_fragmentDevelopment)}
            R.id.nav_film ->{navController.navigate(R.id.action_global_fragmentFilm)}
        }

        return true
    }

    fun runFragmentCoroutines() {
        viewModel.getGraphicsList()
    }

}