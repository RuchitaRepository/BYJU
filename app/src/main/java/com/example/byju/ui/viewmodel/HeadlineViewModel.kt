package com.example.byju.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.byju.data.model.Article
import com.example.byju.data.model.NewsList
import com.example.byju.data.repositories.NewsRepository
import kotlinx.coroutines.Job
import net.simplifiedcoding.util.Coroutines

class HeadlineViewModel(
    private val respository : NewsRepository ) : ViewModel(){
    private lateinit var job: Job
    val _newslist = MutableLiveData<List<Article>>()
    val newslist : LiveData<List<Article>> get() = _newslist

    fun getnewsList() {
        job = Coroutines.ioThenMain(
            { respository.getNewsList() },
            {
           _newslist.value = it?.articles
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}