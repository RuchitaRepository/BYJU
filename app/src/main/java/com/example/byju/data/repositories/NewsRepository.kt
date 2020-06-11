package com.example.byju.data.repositories

import com.example.byju.data.network.MyApi
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.LinkedHashMap


class NewsRepository(
    private val api: MyApi
) : SafeApiRequest() {
    suspend fun getNewsList() = apiRequest {
        val data: MutableMap<String, String> = LinkedHashMap()
        data["q"] = "bitcoin"
        //data["from"] = "2020-05-10"
        data["from"] = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        data["sortBy"] = "publishedAt"
        data["apiKey"] = "b2cc280cb39d44399a08174e5b11b91f"
        api.getNewsList(data) }


}

