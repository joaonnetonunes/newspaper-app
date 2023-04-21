package com.ct.newsapp.service

import com.ct.newsapp.model.ResponseItemSuccess
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @QueryMap map: Map<String, String>,
    ): Response<ResponseItemSuccess?>
}
