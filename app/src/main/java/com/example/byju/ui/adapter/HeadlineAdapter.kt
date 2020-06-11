package com.example.byju.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.byju.R
import com.example.byju.data.model.Article
import com.example.byju.data.model.NewsList
import com.example.byju.databinding.RecyclerviewNewsListBinding
import com.example.byju.listeners.RecyclerViewClickListener


class HeadlineAdapter(private val newsList: List<Article>,
                      private val listener: RecyclerViewClickListener,
                      private val  context: Context
): RecyclerView.Adapter<HeadlineAdapter.MoviesViewHolder>() {
    override fun getItemCount() = newsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_news_list,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewNewsListBinding.newslists = newsList.get(position)

        holder.recyclerviewNewsListBinding.cardview.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewNewsListBinding.cardview, newsList[position])
        }
    }

    inner class MoviesViewHolder(
        val recyclerviewNewsListBinding: RecyclerviewNewsListBinding
    ) : RecyclerView.ViewHolder(recyclerviewNewsListBinding.root){

    }

}

