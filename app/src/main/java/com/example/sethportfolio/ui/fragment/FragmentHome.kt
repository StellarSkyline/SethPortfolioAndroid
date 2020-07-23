package com.example.sethportfolio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sethportfolio.R
import com.example.sethportfolio.data.vmodel.FragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome: Fragment() {

   val viewModel:FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text_view_content.text = viewModel.introText()

    }
}