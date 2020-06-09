package com.example.byju.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "newsdata")
data class NewsData(
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "author")
    val author : String,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "url")
    val url : String,
    @ColumnInfo(name = "url_to_image")
    val urlToImage : String,
    @ColumnInfo(name = "published_at")
    val publishedAt : Date,
    @ColumnInfo(name = "content")
    val content: String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}