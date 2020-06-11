package com.example.byju.data.model

data class NewsList(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)