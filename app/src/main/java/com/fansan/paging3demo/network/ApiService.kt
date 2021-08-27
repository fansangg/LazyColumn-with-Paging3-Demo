package com.fansan.paging3demo.network

import com.fansan.paging3demo.data.entity.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 *@author  sc
 *@version 2021/8/2
 */

interface ApiService {

    @GET("article/list/{pageId}/json")
    suspend fun getList(@Path("pageId") pageNum:Int):BaseResultData<Data?>

    companion object{
        private val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(5000,TimeUnit.MILLISECONDS)
            readTimeout(3000,TimeUnit.MILLISECONDS)
            writeTimeout(3000,TimeUnit.MILLISECONDS)
        }
        fun getService(): ApiService = Retrofit.Builder().baseUrl("https://www.wanandroid.com/")
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}