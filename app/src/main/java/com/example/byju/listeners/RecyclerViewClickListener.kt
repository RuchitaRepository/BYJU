package com.example.byju.listeners

import android.view.View
import com.example.byju.data.model.Article
import com.example.byju.data.model.NewsList
import java.text.FieldPosition

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, newsList: Article)
}