package com.fansan.paging3demo.network

import com.fansan.paging3demo.data.entity.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *@author  sc
 *@version 2021/8/2
 */

interface ApiService {

    @GET("article/list/{pageId}/json")
    suspend fun getList(@Path("pageId") pageNum:Int):BaseResultData<Data?>

    companion object{
        fun getService() = Retrofit.Builder().baseUrl("https://www.wanandroid.com/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}