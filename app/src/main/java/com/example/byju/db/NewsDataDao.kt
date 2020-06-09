package com.example.byju.db

import androidx.room.Insert
import androidx.room.Query

interface NewsDataDao {

    @Insert
    suspend fun addNewsData(newsData: NewsData)

    @Query("SELECT * FROM newsdata ORDER BY id DESC")
    suspend fun getNewsList() : List<NewsData>

}