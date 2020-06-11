package com.example.byju.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.byju.data.repositories.NewsRepository
@Suppress("UNCHECKED_CAST")
class HeadlineViewModelFactory(private val repository: NewsRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HeadlineViewModel(repository) as T
    }

}