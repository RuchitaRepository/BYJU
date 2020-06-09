package com.example.byju.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.byju.R
import kotlinx.android.synthetic.main.fragment_headline_screen.*


class HeadlineScreen : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headline_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        check_view.setOnClickListener {
            val action = HeadlineScreenDirections.actionHeadlineScreenToNewsDetailsScreen()
            Navigation.findNavController(it).navigate(action)
        }
    }
}