package com.example.byju.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.byju.R
import kotlinx.android.synthetic.main.fragment_news_details_screen.*
import net.simplifiedcoding.util.loadImage

class NewsDetailsScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("name", arguments?.getString("name"))
        Log.e("urlToImage", arguments?.getString("urlToImage"))
        Log.e("title", arguments?.getString("title"))
        Log.e("publishAt", arguments?.getString("publishAt"))
        Log.e("description", arguments?.getString("description"))

        loadImage(imageview,arguments?.getString("urlToImage"))
        title.text = arguments?.getString("title")
        description.text = arguments?.getString("description")
        name.text = arguments?.getString("name")
        date.text = arguments?.getString("publishAt")?.substring(0,10)
    }
}