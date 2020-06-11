package com.example.byju.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NewsDataDao {

    @Insert
    suspend fun addNewsData(newsData: NewsData)

    @Query("SELECT * FROM newsdata ORDER BY id DESC")
    suspend fun getNewsList() : List<NewsData>

}