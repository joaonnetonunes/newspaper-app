package com.ct.newsapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConnectionBuilder {

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.PRIMARY_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var newsService: NewsService = retrofit.create(NewsService::class.java)
}
