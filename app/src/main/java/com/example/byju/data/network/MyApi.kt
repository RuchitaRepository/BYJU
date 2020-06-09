package com.example.byju.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    @GET()
   suspend fun getNewsList():Call<ResponseBody>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/everything?q=bitcoin&from=2020-05-08&sortBy=publishedAt&apiKey=b2cc280cb39d44399a08174e5b11b91f")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}