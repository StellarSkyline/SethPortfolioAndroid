package com.example.sethportfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sethportfolio.R
import com.example.sethportfolio.data.adapter.AdapterGraphics
import com.example.sethportfolio.data.app.App
import com.example.sethportfolio.data.vmodel.FragmentViewModel
import kotlinx.android.synthetic.main.fragment_graphics.*

class FragmentGraphics: Fragment() {

    lateinit var adapter:AdapterGraphics
    val viewModel:FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_graphics,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterGraphics(activity?.applicationContext!!)
        recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext!!)
        recycler_view.adapter = adapter
        adapter.setData(viewModel.getGraphicsList())
    }
}

//Firebase Storage
/*
service firebase.storage {
  match /b/{bucket}/o {
    match /{allPaths=**} {
      allow read, write: if request.auth != null;
    }
  }
}
 */