package com.example.byju.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.byju.R
import com.example.byju.data.model.Article
import com.example.byju.data.model.NewsList
import com.example.byju.data.network.MyApi
import com.example.byju.data.repositories.NewsRepository
import com.example.byju.db.NewsDatabase
import com.example.byju.listeners.RecyclerViewClickListener
import com.example.byju.ui.adapter.HeadlineAdapter
import com.example.byju.ui.viewmodel.HeadlineViewModel
import com.example.byju.ui.viewmodel.HeadlineViewModelFactory
import com.example.byju.util.NetworkConnection
import kotlinx.android.synthetic.main.fragment_headline_screen.*
import kotlinx.android.synthetic.main.recyclerview_news_list.*
import java.text.FieldPosition


class HeadlineScreenFragment : Fragment(),RecyclerViewClickListener  {

  private lateinit var factory: HeadlineViewModelFactory
    private lateinit var viewModel: HeadlineViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headline_screen, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MyApi()
        val repository = NewsRepository(api)

       factory = HeadlineViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(HeadlineViewModel::class.java)
        viewModel.getnewsList()
        viewModel.newslist.observe(viewLifecycleOwner, Observer { newslist ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = activity?.baseContext?.let { it1 ->
                    HeadlineAdapter(newslist, this,
                        it1
                    )
                }
            }
        })


    }

    override fun onRecyclerViewItemClick(view: View, newsList: Article) {
        when(view.id){
            R.id.cardview -> {
             //  val action = HeadlineScreenFragmentDirections.actionHeadlineScreenToNewsDetailsScreen()
                var bundle = bundleOf("name" to newsList.source.name,
                "urlToImage" to newsList.urlToImage,
                    "title" to newsList.title,
                    "publishAt" to newsList.publishedAt,
                    "description" to newsList.description
                )
               // Navigation.findNavController(view).navigate(action)
                view.findNavController().navigate(R.id.action_headlineScreen_to_newsDetailsScreen,bundle)

            }

        }
    }
}


