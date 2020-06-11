package com.example.byju.data.network


import android.content.Context
import com.example.byju.data.model.NewsList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.concurrent.TimeUnit


interface MyApi{
    @GET("everything")

    suspend fun getNewsList(
        @QueryMap options: MutableMap<String, String>
    ): Response<NewsList>
    companion object{
        private val logger = HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY)

        // Create OkHttp Client
        private val okHttp = OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(logger)

        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())
                .build()
                .create(MyApi::class.java)
        }
    }


}